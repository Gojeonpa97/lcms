
layui.define(['layer','table','element','index', 'form'], function(exports){
  var layer = layui.layer
      ,table = layui.table
      ,admin = layui.admin
      ,$ = layui.$
      ,element = layui.element
      ,index = layui.index
      ,form = layui.form;
  table.render({
    elem: '#LAY-user-manage'
    ,method:'post'
    ,page: true
    ,url: '/v1/system/user/queryUsers'
    ,request:{
      pageName: 'pageSize' //页码的参数名称，默认：page
      ,limitName: 'pageNum' //每页数据量的参数名，默认：limit
    }
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field: 'id', width: 80, title: 'ID', sort: true}
      ,{field: 'loginName', title: '登录名称'}
      ,{field: 'username', title: '用户名称'}
      ,{field: 'email', title: '邮箱'}
      ,{field: 'phonenumber', title: '手机号'}
      ,{field: 'createTime', title: '创建时间'}
      ,{field: 'description', title: '具体描述'}
      ,{title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-webuser'}
    ]]
    ,text: '对不起，加载出现异常！'
  });

  table.on('tool(LAY-user-manage)', function(obj){
    var data = obj.data;
    console.log(data);
    console.log(obj.event);
    if(obj.event == 'del'){
      layer.confirm('真的删除行么', function(index){
        $.ajax({
          type :'get'
          ,url:'/v1/system/user/delete'
          ,data:{
            id :data.id
          }
          ,success:function (res) {
            table.reload('LAY-user-manage');
            layer.msg('已删除');
          }
        })
      });
    }else if(obj.event == 'edit'){
console.log(index)
      index.openTabsPage("sys/useAdd",'编辑用户');
    }
  })



  exports('user', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});