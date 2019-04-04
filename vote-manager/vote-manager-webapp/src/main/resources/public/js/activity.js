//JavaScript代码区域
layui.use(['table','form','element','jquery','laydate'], function() {
    var table = layui.table;
    var form = layui.form;
    var element = layui.element;
    var $ = layui.$;
    var laydate = layui.laydate;

    // 定义数据表格
    table.render({
        id: 'activityList'
        ,elem: '#activityList'
        ,url: 'http://localhost:8100/vote-manager/vote/activity'
        ,height: 'full-180'
        ,cols: [[
            {field:'activityId', title: '编号'}
            ,{field:'activityName', title: '姓名'}
            ,{field:'scopeName', title: '活动范围 '}
            ,{field:'startTime', title: '开始时间',templet: '<div>{{ layui.util.toDateString(d.createTime, "yyyy-MM-dd HH:mm:ss") }}</div>'}
            ,{field:'endTime', title: '结束时间',templet: '<div>{{ layui.util.toDateString(d.createTime, "yyyy-MM-dd HH:mm:ss") }}</div>'}
            ,{fixed: 'right', title:'操作', toolbar: '#bar', width:120}
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

    // 设置下拉框
    $.getJSON("../../js/province.json",function(data){
        $.each(data, function (index, item) {
            $('#scopeParent').append(new Option(item, index));// 下拉菜单里添加元素
        });
        form.render("select");
    });

    // 设置时间选择器
    laydate.render({
        elem: '#startTime'
    });
    laydate.render({
        elem: '#endTime'
    });
});