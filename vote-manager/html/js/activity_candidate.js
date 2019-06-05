//JavaScript代码区域
layui.use(['table','form','element','jquery'], function(){
    var table = layui.table;
    var form = layui.form;
    var element = layui.element;
    var $ = layui.$;

    var activityId = GetQueryString('activityId');

    // 定义数据表格
    table.render({
        id: 'candidateList'
        ,elem: '#candidateList'
        ,url: 'https://www.yfei.site/vote/manager/api/activity/candidate'
        ,height: 'full-100'
        ,where: {
            activityId: activityId
        }
        ,cols: [[
            {field:'candidateCode', title: '候选人号码'}
            ,{field:'candidateId', title: '候选人编号'}
            ,{field:'candidateName', title: '姓名'}
            ,{field:'votes', title: '获得票数'}
        ]]
        ,request: {
            pageName: 'pageNum' //页码的参数名称，默认：page
            ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
        }
        ,parseData: function(res) { //res 即为原始返回的数据
            return {
                'code': 0, //解析接口状态
                'msg': '', //解析提示文本
                'count': res.total, //解析数据长度
                'data': res.list //解析数据列表
            }
        }
        ,page: true
    });

    // 搜索按钮
    $(document).on('click','#find_button',function(){
        table.reload('candidateList', {where: {candidateName: $('#candidateName').val()}});
        return false;
    });
});

// 获取url参数
function GetQueryString(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}