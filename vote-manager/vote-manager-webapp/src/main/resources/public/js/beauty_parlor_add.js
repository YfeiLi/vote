//JavaScript代码区域
layui.use(['form','element','jquery'], function(){
    var form = layui.form;
    var element = layui.element;
    var $ = layui.$;

    // 添加按钮
    form.on('submit(add)',function(data){
        var params = JSON.stringify(data.field);
        $.ajax({
            url: "http://localhost:8100/vote-manager/vote/scope",
            type: 'post',
            contentType: 'application/json',
            data: params,
            success: function(data){
                layer.msg("添加成功");
                form.reset();
            },
            error: function(jqXHR, textStatus){
                layer.msg(textStatus);
            }
        });
        return false;
    });

    // 设置下拉框
    $.getJSON("/vote-manager/js/province.json",function(data){
        $.each(data, function (index, item) {
            $('#scopeParent').append(new Option(item, index));// 下拉菜单里添加元素
        });
        form.render("select");
    });
});