//JavaScript代码区域
layui.use(['table','form','element','jquery'], function(){
    var table = layui.table;
    var form = layui.form;
    var element = layui.element;
    var $ = layui.$;

    // 定义数据表格
    table.render({
        id: 'scopeList'
        ,elem: '#scopeList'
        ,url: 'http://localhost:8100/vote-manager/vote/scope'
        ,height: 'full-180'
        ,where: {
            scopeLevel: 3
        }
        ,cols: [[
            {field:'scopeId', title: '编号'}
            ,{field:'scopeName', title: '美容院名称 ✎', edit:'text'}
            ,{field:'scopeParentName', title: '省份'}
            ,{field:'description', title: '详细描述 ✎', width: 250, edit:'text'}
            ,{field:'createTime', title: '添加时间',templet: '<div>{{ layui.util.toDateString(d.createTime, "yyyy-MM-dd HH:mm:ss") }}</div>'}
            ,{fixed: 'right', title:'操作', toolbar: '#bar', width:130}
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

    // 监听数据编辑
    table.on('edit(scopeList)', function(obj){
        var value = obj.value //得到修改后的值
            ,data = obj.data //得到所在行所有键值
            ,field = obj.field; //得到字段
        $.ajax({
            url:'http://localhost:8100/vote-manager/vote/scope/'+data.scopeId,
            type:'put',
            data:data,
            success:function(){
                layer.msg("编辑成功");
            },
            error: function(jqXHR, textStatus){
                layer.msg(textStatus);
            }
        })
    });

    // 监听删除数据
    table.on('tool(scopeList)',function(obj){
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

        if(layEvent === 'del') { //删除
            layer.confirm('真的删除行么', function(index){
                layer.close(index);
                //向服务端发送删除指令
                $.ajax({
                    url:'http://localhost:8100/vote-manager/vote/scope/'+data.scopeId,
                    type:'delete',
                    success:function () {
                        table.reload('scopeList');
                    },
                    error: function(jqXHR, textStatus){
                        layer.msg(textStatus);
                    }
                });
            });
        } else if(layEvent === 'candidate'){ // 候选人
            layer.open({
                type: 2,
                title: data.scopeName+" - 候选人管理",
                area:['950px','550px'],
                shade: 0.3,
                offset: "5%",
                content:'candidate.html?scopeId='+data.scopeId
            });
        }
    });

    // 监听下拉框修改值
    form.on('select(changeSelect)',function(data){
        table.reload('scopeList', {where: {scopeParent: data.value}});
    });

    // 添加按钮
    $(document).on('click','#add_button',function(){
        layer.open({
            type: 2,
            title: '添加美容院',
            area:['500px','350px'],
            shade: 0.3,
            offset: "20%",
            content:'beauty_parlor_add.html'
        });
    });

    // 设置下拉框
    $.getJSON("../../js/province.json",function(data){
        $.each(data, function (index, item) {
            $('#scopeParent').append(new Option(item, index));// 下拉菜单里添加元素
        });
        form.render("select");
    });
});