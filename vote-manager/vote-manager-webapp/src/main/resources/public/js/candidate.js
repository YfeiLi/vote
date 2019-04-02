//JavaScript代码区域
layui.use(['table','form','element','jquery'], function(){
    var table = layui.table;
    var form = layui.form;
    var element = layui.element;
    var $ = layui.$;

    // 定义数据表格
    table.render({
        id: 'candidateList'
        ,elem: '#candidateList'
        ,url: 'http://localhost:8100/vote-manager/vote/candidate'
        ,height: 'full-100'
        ,where: {
            scopeId: GetQueryString('scopeId')
        }
        ,cols: [[
            {field:'candidateId', title: '编号'}
            ,{field:'candidateName', title: '姓名'}
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

    // 搜索按钮
    $(document).on('click','#find_button',function(){
        table.reload('candidateList', {where: {candidateName: $('#candidateName').val()}});
        return false;
    });
});

function GetQueryString(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}