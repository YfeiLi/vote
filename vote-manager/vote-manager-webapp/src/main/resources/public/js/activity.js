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
        ,url: 'http://localhost:8100/vote-manager/activity'
        ,where: {
            startTime: $('#startTime').val(),
            endTime: $('#endTime').val()
        }
        ,height: 'full-180'
        ,cols: [[
            {field:'activityId', title: '编号'}
            ,{field:'activityName', title: '活动名称'}
            ,{field:'scopeName', title: '活动范围 '}
            ,{field:'candidateNum', title: '候选人数量 '}
            ,{field:'startTime', title: '开始时间',templet: '<div>{{ layui.util.toDateString(d.startTime, "yyyy-MM-dd") }}</div>'}
            ,{field:'endTime', title: '结束时间',templet: '<div>{{ layui.util.toDateString(d.endTime, "yyyy-MM-dd") }}</div>'}
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

    // 设置时间选择器
    laydate.render({
        elem: '#startTime'
        ,done: function(){
            table.reload('activityList', {where: {
                startTime: $('#startTime').val(),
                endTime: $('#endTime').val()
            }});
        }
    });
    laydate.render({
        elem: '#endTime'
        ,done: function(){
            table.reload('activityList', {where: {
                startTime: $('#startTime').val(),
                endTime: $('#endTime').val()
            }});
        }
    });

    // 添加按钮
    $(document).on('click','#add_button',function(){
        layer.open({
            type: 2,
            title: '添加活动',
            area:['650px','560px'],
            shade: 0.3,
            offset: "5%",
            content:'activity_add.html'
        });
    });

    // 监听数据操作
    table.on('tool(activityList)',function(obj){
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

        if(layEvent === 'del') { //删除
            layer.confirm('真的删除行么', function(index){
                layer.close(index);
                //向服务端发送删除指令
                $.ajax({
                    url:'http://localhost:8100/vote-manager/activity/'+data.activityId,
                    type:'delete',
                    success:function () {
                        table.reload('activityList');
                    },
                    error: function(jqXHR, textStatus){
                        layer.msg(textStatus);
                    }
                });
            });
        } else if(layEvent === 'detail'){ // 详情
            layer.open({
                type: 2,
                title: data.activityName+" - 活动详情",
                area:['800px','550px'],
                shade: 0.3,
                offset: "5%",
                content:'activity_candidate.html?activityId='+data.activityId
            });
        }
    });
});