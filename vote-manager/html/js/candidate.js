//JavaScript代码区域
layui.use(['table','form','element','jquery'], function(){
    var table = layui.table;
    var form = layui.form;
    var element = layui.element;
    var $ = layui.$;

    var scopeId = GetQueryString('scopeId');

    // 定义数据表格
    table.render({
        id: 'candidateList'
        ,elem: '#candidateList'
        ,url: 'https://www.yfei.site/vote/manager/api/candidate'
        ,height: 'full-100'
        ,where: {
            scopeId: scopeId
        }
        ,cols: [[
            {field:'candidateId', title: '编号'}
            ,{field:'candidateName', title: '姓名'}
            ,{field:'description', title: '详细描述 ', width: 250}
            ,{field:'createTime', title: '添加时间',templet: '<div>{{ layui.util.toDateString(d.createTime, "yyyy-MM-dd HH:mm:ss") }}</div>'}
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

    // 搜索按钮
    $(document).on('click','#find_button',function(){
        table.reload('candidateList', {where: {candidateName: $('#candidateName').val()}});
        return false;
    });

    // 添加按钮
    $(document).on('click','#add_button',function(){
        layer.open({
            type: 2,
            title: '添加候选人',
            area:['650px','480px'],
            shade: 0.3,
            offset: "3%",
            content:'candidate_add.html?scopeId='+scopeId
        });
    });

    // 监听数据操作
    table.on('tool(candidateList)',function(obj){
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

        if(layEvent === 'del') { //删除
            layer.confirm('真的删除行么', function(index){
                layer.close(index);
                //向服务端发送删除指令
                $.ajax({
                    url:'https://www.yfei.site/vote/manager/api/candidate/'+data.candidateId,
                    type:'delete',
                    success:function () {
                        table.reload('candidateList');
                    },
                    error: function(jqXHR, textStatus){
                        layer.msg(textStatus);
                    }
                });
            });
        } else if(layEvent === 'detail'){ // 详情
            layer.open({
                type: 2,
                title: '候选人详情',
                area:['650px','480px'],
                shade: 0.3,
                offset: "3%",
                content:'candidate_edit.html?candidateId='+data.candidateId
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