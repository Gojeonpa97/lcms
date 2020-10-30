
layui.define(['layer','table', 'form'], function(exports){
  var json = "123123";
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
      ,{field: 'sid', width: 80, title: 'ID', sort: true}
      ,{field: 'name', title: '角色名'}
      ,{field: 'sort', title: '顺序'}
      ,{field: 'status', title: '角色状态', templet: '#statusTpl', unresize: true}
      ,{field: 'createUser', title: '创建者'}
      ,{field: 'createTime', title: '创建时间'}
      ,{field: 'description', title: '具体描述'}
      ,{title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-admin'}
    ]],
    done: function(res, curr, count){
      //如果是异步请求数据方式，res即为你接口返回的信息。
      //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
      $("[data-field='name']").children().each(function(){
        if($(this).text()=='0'){
          $(this).text("管理员")
        }else if($(this).text()=='1'){
          $(this).text("超级管理员")
        }else if($(this).text()=='2'){
          $(this).text("纠错员")
        }else if($(this).text()=='3'){
          $(this).text("采购员")
        }else if($(this).text()=='4'){
          $(this).text("推销员")
        }else if($(this).text()=='5'){
          $(this).text("运营人员")
        }else if($(this).text()=='6'){
          $(this).text("编辑")
        }
      })
    },
    text: '对不起，加载出现异常！'
  });
  //监听工具条
  table.on('tool(LAY-user-back-role)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('确定删除此角色？', function(index){
        obj.del();
        layer.close(index);
      });
    }else if(obj.event === 'edit'){
      var sid =data.sid
      layer.open({
        type: 2
        ,title: '编辑角色'
        ,content: '/sys/roleTree?sid='+sid
        ,area: ['500px', '480px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){

          var iframeWindow = window['layui-layer-iframe'+ index]
              ,submit = layero.find('iframe').contents().find("#LAY-user-role-submit");

          //监听提交
          iframeWindow.layui.form.on('submit(LAY-user-role-submit)', function(data){
            var field = data.field; //获取提交的字段
            //提交 Ajax 成功后，静态更新表格中的数据
            //$.ajax({});
            table.reload('LAY-user-back-role'); //数据刷新
            layer.close(index); //关闭弹层
          });

          submit.trigger('click');
        }
        ,success: function(layero, index){
          var role = layer.getChildFrame('#layuiadmin-form-role', index);


        }
      })
    }
  });

  $('.layui-btn.layuiadmin-btn-role').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
  var active = {
    batchdel: function(){
      var checkStatus = table.checkStatus('LAY-user-back-role')
          ,checkData =checkStatus.data; //得到选中的数据
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
    add: function(){
      layer.open({
        type: 2
        ,title: '添加角色'
        ,content: '/sys/addRole'
        ,maxmin: true
        ,area: ['550px', '300px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          var iframeWindow = window['layui-layer-iframe'+ index]
              ,submitID = 'LAY-role-front-submit'
              ,submit = layero.find('iframe').contents().find('#'+ submitID);
          //监听提交
          iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
            var field = data.field; //获取提交的字段
            console.log(field);
            //提交 Ajax 成功后，静态更新表格中的数据
            //$.ajax({});
            $.ajax({
              type:"post",
              url:"/v1/system/role/insert",
              data:field,
              success:function(data){
                table.reload('LAY-user-back-role');
                layer.close(index);
              }
            });
          });
          submit.trigger('click');
        }
      });
    }
  };
  table.on('tool(LAY-user-back-role)', function(obj){
    var data = obj.data;
    var id = data.id;
    layer.open({
      type: 2
      ,title: '修改用户'
      ,content: '/sys/addRole?id='+id
      ,maxmin: true
      ,area: ['550px', '300px']
      ,btn: ['确定', '取消']
      ,yes: function(index, layero){
        var iframeWindow = window['layui-layer-iframe'+ index]
            ,submitID = 'LAY-role-front-submit'
            ,submit = layero.find('iframe').contents().find('#'+ submitID);
        //监听提交
        iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
          var field = data.field;
          //提交 Ajax 成功后，静态更新表格中的数据
          $.ajax({
            type:"post",
            url:"/v1/system/role/update",
            data:field,
            success:function(data){
              table.reload('LAY-user-back-role'); //数据刷新
              layer.close(index); //关闭弹层
            }
          });
        });
        submit.trigger('click');
      }
    });
  });
  form.on('submit(LAY-role-front-search)', function(data){
    var field = data.field;
    console.log(field);
    //执行重载
    table.reload('LAY-user-back-role', {
      where: field
    });
  });
  //监听性别操作
  form.on('switch(sexDemo)', function(obj){
    layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
  });
  exports('role', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});