<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>网站用户</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${staticPath}/public/assets/css/fontawesome-free/all.min.css">
    <link rel="stylesheet" href="${staticPath}/public/assets/css/adminlte.min.css">
    <link rel="stylesheet" href="${staticPath}/public/assets/css/bootstrap/bootstrap.min.css">
</head>
<body>
<div class="wrapper">
    <div class="container-fluid" style="padding: 20px 0 0 20px;">
        <div class="row">
            <div class="col-md-6">
                <form class="form-horizontal" id="addTplForm">
                    <div class="form-group row">
                        <label  class="col-sm-2 col-form-label">登录名称<i style=" color: red;">*</i></label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="loginName" id="loginname" placeholder="登录名称" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label  class="col-sm-2 col-form-label">用户名</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="username" id="username" placeholder="用户名">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label  class="col-sm-2 col-form-label">邮箱</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="email" id="email" placeholder="邮箱">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label  class="col-sm-2 col-form-label">手机号码</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="phonenumber" id="phonenumber" placeholder="手机号码">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="${staticPath}/public/assets/js/jquery/jquery.min.js"></script>
<script src="${staticPath}/common/utils.js"></script>
<script>
    var sid = $.getParamByUrl('sid');
    var param = {pageNum: 0, pageSize: 10,sid: sid};
    $.RestSyncAjax('/v1/system/user/queryUsers','POST',param,function (result) {
        if(result.success){
            $.each(result.data.records,function (k,item) {
                $('#loginname').val(item.loginName);
                $('#username').val(item.username);
                $('#email').val(item.email);
                $('#phonenumber').val(item.phonenumber);
            })
        }
    });

</script>
</body>
</html>
