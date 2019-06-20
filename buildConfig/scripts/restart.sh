#!/bin/bash

cd `dirname $0`

JAR_FILE=`find -name *.jar`
PROJECT_NAME=`basename $JAR_FILE .jar`

JAR_PID_CMD='ps aux | grep "java" | grep "\-jar" | egrep "(${PROJECT_NAME}.jar)" | awk "{print \$2}"'
JAR_PID=$(eval ${JAR_PID_CMD})
if [[ -n "$JAR_PID" ]]; then
  sudo kill -9 $JAR_PID
fi
sudo nohup java -Xbootclasspath/a:./resources -Xmx128m -Xms128m -Xmn50m -Xss128k -XX:ParallelGCThreads=2 -Djava.compiler=NONE -jar ${PROJECT_NAME}.jar spring &>> /data/logs/soar/${PROJECT_NAME}.log &
sleep 10s
tail -50 /data/logs/soar/${PROJECT_NAME}.log

