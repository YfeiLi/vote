//JavaScript代码区域
layui.use(['form','element','jquery','upload'], function(){
    var form = layui.form
        ,element = layui.element
        ,$ = layui.$
        ,upload = layui.upload;

    var candidateId = GetQueryString(candidateId);

    // 查询
    $.ajax({
        url: 'https://www.yfei.site/candidate/'+GetQueryString('candidateId'),
        type: 'get',
        success:function (result) {
            $('#thumbnail').attr('src',result.photoUrl);
            $('#candidateName').val(result.candidateName);
            $('#description').val(result.description);
        },
        error: function(jqXHR, textStatus){
            layer.msg(textStatus);
        }
    });

    // 编辑按钮
    form.on('submit(edit)',function(data){
        var params = data.field;
        $.ajax({
            url: "https://www.yfei.site/candidate/"+GetQueryString('candidateId'),
            type: 'put',
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