#!/usr/bin/env bash


Check_JarFile() {
  # 检查当前应用目录下jar文件是否存在
  # 如果不存在, 那就退出
  HERE=$(pwd)
  JAR_FILE_PATH=$(find "$HERE" -maxdepth 1 -type f -name \*.jar)
  if [[ -z "$JAR_FILE_PATH" ]]; then
    echo "[ERROR] ${HERE}: 丢失jar文件, 请检查."
    return 7
  fi
  JAR_FILE=$(basename ${JAR_FILE_PATH})
  return
}

Check_JarFile || exit 0

export HERE
export JAR_FILE_PATH
export JAR_FILE

# 启动当前应用的普通用户
OWNER_USER="build"

# JAVA_HOME
JAVA_HOME="/usr/local/jdk"

# JAVA选项
# JAVA_OPTS=""

# JAVA参数
# JAVA_ARGS=""

# 日志目录, 需要对OWNER_USER用户有写入的权限
# 应该提前创建
LOGS_BASE="/data/logs/soar"

# 记录脚本执行的情况, 什么时候被执行过，执行了哪些东西
TEMP_OPS_DIR="/tmp/.ops"
LOG_FILE="${TEMP_OPS_DIR}/jarserver.log"

# 等待时间(s)
WAIT_TIME=12

# 颜色常量
GREEN="\e[1;32m"
RED="\e[1;31m"
YELLOW="\e[1;33m"
END="\e[0m"

# 字符串方式获取jar文件启动的pid，通过eval命令解析，不是直接取pid
JAR_PID='ps aux | grep "java" | grep "\-jar" | egrep "(${JAR_FILE_PATH}|${JAR_FILE})" | awk "{print \$2}"'
export OWNER_USER JAVA_HOME LOGS_BASE LOG_FILE WAIT_TIME
export GREEN RED YELLOW END
export PATH="$JAVA_HOME"/bin:$PATH
export JAR_PID

# 对printf一个包装, 用于打印
print() { printf "%s\n" "$*"; } 

# 输出带颜色的字符串
notice() { printf "${GREEN}%s${END}\n" "$*"; }
warn() { printf "${YELLOW}%s${END}\n" "$*"; }
error() { printf "${RED}%s${END}\n" "$*"; }

_now() {
  # 获取当前时间, 格式是YYYY-mm-dd HH:MM:SS
  date +"%Y-%m-%d %H:%M:%S"
  return
}

_logger() {
  # 写入日志信息到文件 
  # 日志文件格式是: 时间 当前用户 内容
  local msg=$@
  [[ -z ${msg} ]] && return 1
  print "$(_now) ${USER} ${msg}" >> ${LOG_FILE}
  return
}

check_env() {

  # 检查环境
  #if [[ "$USER" != "$OWNER_USER" ]]; then
  #  local msg="[ERROR] 当前用户${USER}没有权限执行脚本, 请切换至${OWNER_USER}用户执行."
  #  _logger "$msg"; error "$msg"; unset msg
  #  return 6

  if [[ ! -d "$JAVA_HOME" ]]; then
    local msg="[EROOR] ${JAVA_HOME}：不能找到java."
    _logger "$msg"; error "$msg"; unset msg
    return 5

  elif [[ ! -x "$JAVA_HOME"/bin/java ]]; then
    local msg="[ERROR] ${JAVA_HOME}/bin/java: 没有执行权限."
    _logger "$msg"; error "$msg"; unset msg
    return 4

  elif [[ ! -d "$LOGS_BASE" ]]; then
    local msg="[ERROR] 日志目录 ${LOGS_BASE}: 不存在请创建, 并赋予${OWNER_USER}写入权限."
    _logger "$msg"; error "$msg"; unset msg
    return 3

  elif [[ ! -w "$LOGS_BASE" ]]; then
    local msg="[ERROR] 日志目录 ${LOGS_BASE}: 对${OWNER_USER}用户没有写入权限, 请检查."
    _logger "$msg"; error "$msg"; unset msg
    return 2
  fi
  [[ -d ${TEMP_OPS_DIR} ]] || \
  	mkdir -p ${TEMP_OPS_DIR} &> /dev/zero
  return
}

start() {
  
  # 启动jar，如果已经启动会略过, 否则就启动
  # 检查环境
  check_env || exit 1

  # 标记是否为略过启动, 默认为false
  local skip=false

  # 标记行，初始为0
  local end_line=0

  # 取pid
  local jar_pid=$(eval ${JAR_PID})
  
  # 如果获取的pid为空说明没有启动，那就启动
  if [[ -z "$jar_pid" ]]; then

    # 定义输出的日志文件
    local logfile=${LOGS_BASE}/${JAR_FILE}.log
    
    # 如果日志文件存在, 先记录有多少行, 作为打印日志的起始行
    if [[ -f "$logfile" ]]; then
      local end_line=$(wc -l "$logfile" | awk '{print $1}')
    fi
    
    # 启动
    nohup java -Xbootclasspath/a:./config -jar "$JAR_FILE" spring &>> "$logfile" &

    # 屏幕输出并写入日志
    local msg="启动 ======> ${JAR_FILE_PATH}"
    _logger "$msg"; notice "$msg"

  else
    # 说明已经启动了, 略过
    local msg="略过 (正在运行) ======> ${JAR_FILE_PATH}"
    _logger "$msg"; warn "$msg"

    # 标记为true
    local skip=true
  fi
  
  # 说明不是略过启动，打印日志
  # 仅打印这次启动的日志，而不是旧的的日志
  if [[ "$skip" == false ]]; then
    if [[ "$end_line" -gt 0 ]]; then
      sleep "$WAIT_TIME"
      sed -n "${end_line},\$p" "$logfile"
    else
      tail -50 "$logfile"
    fi
  fi
  return
}

stop() {
  # 停止jar服务
  # 取jar包的pid
  local jar_pid=$(eval ${JAR_PID})

  if [[ -z "$jar_pid" ]]; then
    local msg="略过 (已停止运行) ======> ${JAR_FILE_PATH}"
    _logger "$msg"; warn "$msg"; unset msg
  else
    local msg="停止 ======> ${JAR_FILE_PATH}"
    _logger "$msg"; error "$msg"
    kill -9 "$jar_pid" &> /dev/zero
    unset msg
  fi
  return
}

status() {
  # 查看状态
  # 取jar包的pid
  local jar_pid=$(eval ${JAR_PID})
  if [[ -z "$jar_pid" ]]; then
    local msg="停止运行 ======> ${JAR_FILE_PATH}"
    _logger "$msg"; error "$msg"
  else
    local msg="运行中 (pid: ${jar_pid}) ======> ${JAR_FILE_PATH}"
    _logger "$msg"; notice "$msg"
  fi
  return
}

restart() {
  stop
  start
}

tailog() {
  local logfile=${LOGS_BASE}/${JAR_FILE}.log
  if [[ -f "$logfilel" ]]; then
  	local msg="[ERROR] ${logfile}: 不存在的文件"
  	error "$msg"
  	return 4
  fi
  print "log: ${logfile}"
  tail -f "$logfile"
}


case "$1" in
  start )
    _logger "start ========================================================================"
    start ;;
  stop )
    _logger "stop ========================================================================="
    stop ;;
  status )
    _logger "status ======================================================================="
    status ;;
  restart )
    _logger "restart ======================================================================"
    restart ;;
  tailog )
    _logger "tailog ======================================================================"
    tailog
    ;;
      * )
     echo "Usage: $0 {start|stop|restart|status|tailog}"
esac
exit $?
