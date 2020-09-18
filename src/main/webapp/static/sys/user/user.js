
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

  
  form.on('submit(LAY-user-front-search)', function(data){
      var field = data.field;
      //执行重载
      table.reload('LAY-user-manage', {
        where: field
      });
    });
  
  
  table.on('tool(LAY-user-manage)', function(obj){
    var data = obj.data;
    var id = data.id;
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
    	layer.open({
            type: 2
            ,title: '修改用户'
            ,content: '/sys/userAdd?id='+id
            ,maxmin: true
            ,area: ['550px', '550px']
            ,btn: ['确定', '取消']
            ,yes: function(index, layero){
              var iframeWindow = window['layui-layer-iframe'+ index]
              ,submitID = 'LAY-user-front-submit'
              ,submit = layero.find('iframe').contents().find('#'+ submitID);
              
              //监听提交
               iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
                var field = data.field; //获取提交的字段
                
                //提交 Ajax 成功后，静态更新表格中的数据
               $.ajax({
              	 type:"post",
              	 url:"/v1/system/user/update",
              	 data:field,
              	 success:function(data){
              		table.reload('LAY-user-manage'); //数据刷新
                    layer.close(index); //关闭弹层
              	 }
                }); 
                
              });   
              
              submit.trigger('click');
            }
          });    	    	
    }
  })



  var active = {
          add: function(){
            layer.open({
              type: 2
              ,title: '添加用户'
              ,content: '/sys/userAdd'
              ,maxmin: true
              ,area: ['550px', '550px']
              ,btn: ['确定', '取消']
              ,yes: function(index, layero){
                var iframeWindow = window['layui-layer-iframe'+ index]
                ,submitID = 'LAY-user-front-submit'
                ,submit = layero.find('iframe').contents().find('#'+ submitID);
                
                //监听提交
                 iframeWindow.layui.form.on('submit('+ submitID +')', function(data){                	 
                  var field = data.field; //获取提交的字段
                  
                  //提交 Ajax 成功后，静态更新表格中的数据
                  //$.ajax({});
                 $.ajax({
                	 type:"post",
                	 url:"/v1/system/user/insert",
                	 data:field,
                	 success:function(data){
                		 table.reload('LAY-user-manage');
                		 layer.close(index);
                	 }
                  });  
                  
                });   
                
                submit.trigger('click');
              }
            }); 
          }
        };
        $('.layui-btn.layuiadmin-btn-useradmin').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
          });


  exports('user', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});