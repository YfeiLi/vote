//JavaScript代码区域
layui.use(['form','element','jquery','upload'], function(){
    var form = layui.form
        ,element = layui.element
        ,$ = layui.$
        ,upload = layui.upload;

    // 添加按钮
    form.on('submit(add)',function(data){
        var params = JSON.stringify(data.field);
        $.ajax({
            url: "https://www.yfeili.cn/vote/manager/api/candidate",
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

    // 设置美容院编号
    $("#scopeId").val(GetQueryString("scopeId"));

    //普通图片上传
    var uploadInst = upload.render({
        elem: '#thumbnail'
        ,auto: false
        ,choose: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#thumbnail').attr('src', result);
                $('#photo').val(result.substr(result.indexOf(',')+1,result.length));
            });
        }
    });
});

// 获取url参数
function GetQueryString(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}