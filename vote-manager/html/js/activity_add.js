//JavaScript代码区域
layui.use(['form','element','jquery','laydate'], function(){
    var form = layui.form
        ,element = layui.element
        ,$ = layui.$
        ,upload = layui.upload
        ,laydate = layui.laydate;

    // 添加按钮
    form.on('submit(add)',function(data){
        var params = JSON.stringify(data.field);
        $.ajax({
            url: "https://www.yfeili.cn/vote/manager/api/activity",
            type: 'post',
            contentType: 'application/json',
            data: params,
            success: function(data){
                parent.window.location.reload();
            },
            error: function(jqXHR, textStatus){
                layer.msg(textStatus);
            }
        });
        return false;
    });

    // 设置省份
    $.getJSON("../../js/province.json",function(data){
        $('#province').append(new Option("请选择", ""));
        $.each(data, function (index, item) {
            $('#province').append(new Option(item, index));// 下拉菜单里添加元素
        });
        form.render("select","province");
    });
    // 设置时间选择器
    laydate.render({
        elem: '#startTime'
    });
    laydate.render({
        elem: '#endTime'
    });

    // 监听下拉框scope_level修改值
    form.on('select(scope_level)',function(data){

        var scopeLevel = data.value;
        if(scopeLevel == 1){
            $('#province').attr('disabled',true);
            $('#beauty_parlor').attr('disabled',true);
            $('#scopeId').val('00011');
            $('#province').val('');
            $('#beauty_parlor').val('');
        } else if(scopeLevel == 2){
            $('#province').attr('disabled',false);
            $('#beauty_parlor').attr('disabled',true);
            $('#scopeId').val('');
            $('#province').val('');
            $('#beauty_parlor').val('');
        } else if(scopeLevel == 3){
            $('#province').attr('disabled',false);
            $('#beauty_parlor').attr('disabled',false);
            $('#scopeId').val('');
            $('#province').val('');
            $('#beauty_parlor').val('');
        }
        form.render("select");
    });

    // 监听下拉框province修改值
    form.on('select(province)',function(data){

        var province = data.value;
        if($('#scope_level').val() == 2){
            $('#scopeId').val(province);
        } else{
            $('#scopeId').val('');
            $.ajax({
                url: 'https://www.yfeili.cn/vote/manager/api/scope',
                type: 'get',
                data:{scopeLevel:3,scopeParent:province},
                success: function(data){
                    var beautyParlorList = data.list;
                    $('#beauty_parlor').empty();
                    $('#beauty_parlor').append(new Option("请选择", ""));// 下拉菜单里添加元素
                    beautyParlorList.forEach(function(beautyParlor){
                        $('#beauty_parlor').append(new Option(beautyParlor.scopeName, beautyParlor.scopeId));// 下拉菜单里添加元素
                    });
                    $('#beauty_parlor').val('');
                    form.render("select");
                }
            });
        }
    });

    // 监听下拉框beauty_parlor修改值
    form.on('select(beauty_parlor)',function(data){
        $('#scopeId').val(data.value);
    });
});