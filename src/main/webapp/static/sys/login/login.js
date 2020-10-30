
layui.define(['layer','table','element', 'form'], function(exports){
  var $ = layui.$
      ,form = layui.form
      ,admin = layui.admin;
  var $body = $('body');
  form.render();

  //自定义验证
  form.verify({
    username: function(value, item){ //value：表单的值、item：表单的DOM对象
      if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
        return '用户名不能有特殊字符';
      }
      if(/(^\_)|(\__)|(\_+$)/.test(value)){
        return '用户名首尾不能出现下划线\'_\'';
      }
      if(/^\d+\d+\d$/.test(value)){
        return '用户名不能全为数字';
      }
    }
    //我们既支持上述函数式的方式，也支持下述数组的形式
    //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
    ,password: [
      /^[\S]{4,12}$/
      ,'密码必须4到12位，且不能出现空格'
    ]
  });
  //提交
  form.on('submit(LAY-user-login-submit)', function(obj){
    //请求登入接口
    $.ajax({
      url: '/login'
      ,type:'post'
      ,data: JSON.stringify(obj.field)
      , headers: {
            "Content-Type": "application/json;charse=UTF-8"
        }
      ,success: function(res){
        //请求成功后，写入 access_token
        // layui.data(setter.tableName, {
        //   key: setter.request.tokenName
        //   ,value: res.data.access_token
        // });
       if(res.success == true ){
         //登入成功的提示与跳转
         layer.msg('登入成功', {
           offset: '15px'
           ,icon: 1
           ,time: 1000
         }, function(){
           location.href = 'index'; //后台主页
         });
       }else{
         layer.msg(res.errorMessage)
          $('#LAY-user-get-vercode').click();
          $('#vercode').val("");
       }
      },
      // error: function (XMLHttpRequest, textStatus, errorThrown) {
      //
      //  layer.msg();
      // }
    });

  });


  //更换图形验证码
  $body.on('click', '#LAY-user-get-vercode', function(){
    var othis = $(this);
    this.src = '/captcha?t='+ new Date().getTime()
  });
  exports('login', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
})
