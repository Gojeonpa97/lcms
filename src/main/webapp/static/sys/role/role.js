
layui.define(['layer','table', 'form'], function(exports){
  var layer = layui.layer
      ,table = layui.table
      ,form = layui.form;
  table.render({
    elem: '#LAY-user-back-role'
    ,method:'post'
    ,page: true
    ,url: '/v1/system/role/roles'
    ,request:{
      pageName: 'pageSize' //页码的参数名称，默认：page
      ,limitName: 'pageNum' //每页数据量的参数名，默认：limit
    }
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field: 'id', width: 80, title: 'ID', sort: true}
      ,{field: 'name', title: '角色名'}
      ,{field: 'sort', title: '顺序'}
      ,{field: 'status', title: '角色状态', templet: '#statusTpl', unresize: true}
      ,{field: 'createUser', title: '创建者'}
      ,{field: 'createTime', title: '创建时间'}
      ,{field: 'description', title: '具体描述'}
      ,{title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-admin'}
    ]]
    ,text: '对不起，加载出现异常！'
  });

  exports('role', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
  $('.layui-btn.layuiadmin-btn-role').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
  var active = {
    batchdel: function(){
      var checkStatus = table.checkStatus('LAY-user-back-role')
          ,checkData =checkStatus.data; //得到选中的数据
      for(i = 0,i < checkData.length;i++;){
        console.log(checkData[i])
      };
      if(checkData.length === 0){
        return layer.msg('请选择数据');
      }

      layer.confirm('确定删除吗？', function(index) {

        //执行 Ajax 后重载
       $.ajax({
          url: 'v1/system/role/delete'
          ,type: 'get'
          ,data:{
            id: checkData
          }
          ,success: function(res) {
            table.reload('LAY-user-back-role');
            layer.msg('已删除', {
              icon: 1
              , shade: 0
            })
          }
        });
      });
    },
  };
  //监听性别操作
  form.on('switch(sexDemo)', function(obj){
    console.log("123123"+obj)
    layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
  });
});