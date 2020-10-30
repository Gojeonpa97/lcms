<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AdminLTE 3 | User Profile</title>
    <link rel="stylesheet" href="${staticPath}/public/assets/css/adminlte.min.css">
    <link rel="stylesheet" href="${staticPath}/public/assets/css/fontawesome-free/all.min.css">
    <link rel="stylesheet" href="${staticPath}/public/assets/css/tempusdominus-bootstrap-4/tempusdominus-bootstrap-4.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Profile</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">User Profile</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3">

                        <!-- Profile Image -->
                        <div class="card card-primary card-outline">
                            <div class="card-body box-profile">
                                <div class="text-center">
                                    <img class="profile-user-img img-fluid img-circle"
                                         src="${staticPath}/public/assets/images/user4-128x128.jpg"
                                         alt="User profile picture">
                                </div>

                                <h3 class="profile-username text-center">Nina Mcintire</h3>

                                <p class="text-muted text-center">Software Engineer</p>

                                <ul class="list-group list-group-unbordered mb-3">
                                    <li class="list-group-item">
                                        <b>登录名称：</b> <a class="float-right">1,322</a>
                                    </li>
                                    <li class="list-group-item">
                                        <b>手机号码：</b> <a class="float-right">543</a>
                                    </li>
                                    <li class="list-group-item">
                                        <b>邮箱地址：</b> <a class="float-right">13,287</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-md-9">
                        <div class="card">
                            <div class="card-header p-2">
                                <ul class="nav nav-pills">
                                    <li class="nav-item"><a class="nav-link active" href="#activity" data-toggle="tab">基本资料</a></li>
                                    <li class="nav-item"><a class="nav-link" href="#settings" data-toggle="tab">修改密码</a></li>
                                </ul>
                            </div><!-- /.card-header -->
                            <div class="card-body">
                                <div class="tab-content">
                                    <div class="active tab-pane" id="activity">
                                        <form class="form-horizontal">
                                            <div class="form-group row">
                                                <label for="userName" class="col-sm-2 col-form-label">用户名称：</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="userName" placeholder="用户名称">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="phonenumber" class="col-sm-2 col-form-label">手机号码：</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="phonenumber" placeholder="手机号码">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="email" class="col-sm-2 col-form-label">邮箱：</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="email" placeholder="邮箱">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">性别：</label>
                                                <div class="col-sm-10">
                                                    <div class="radio-box">
                                                        <input type="radio" id="radio1"  name="sex" value="0">
                                                        <label for="radio1">男</label>

                                                        <input type="radio" id="radio2"  name="sex" value="1">
                                                        <label for="radio2">女</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                            <label for="description" class="col-sm-2 col-form-label">备注：</label>
                                                <div class="col-sm-10">
                                                <textarea class="form-control" id="description" placeholder="2-500字"></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <div class="offset-sm-2 col-sm-10">
                                                    <button type="button" class="btn btn-primary"><i class="fa fa-check"></i>保存</button>&nbsp;&nbsp;
                                                    <button type="button" class="btn btn-danger"><i class="fa fa-reply-all"></i>取消</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <!-- 修改密码 -->
                                    <div class="tab-pane" id="settings">
                                        <form class="form-horizontal" id="user-resetPassword">
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">旧密码：</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="oldPassword" id="oldPassword" placeholder="旧密码">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">新密码：</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="newPassword" id="newPassword" placeholder="新密码">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">确认密码：</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="confirmPassword" id="confirmPassword" placeholder="确认密码">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <div class="offset-sm-2 col-sm-10">
                                                    <button type="button" class="btn btn-primary" onclick="submit_btn();"><i class="fa fa-check"></i>保存</button>&nbsp;
                                                    <button type="button" class="btn btn-danger"><i class="fa fa-reply-all"></i>取消</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <!-- /.tab-pane -->
                                </div>
                                <!-- /.tab-content -->
                            </div><!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div><!-- /.container-fluid -->
        </section>
</div>
<!-- jQuery -->
<script src="${staticPath}/public/assets/js/jquery/jquery.min.js"></script>
<script src="${staticPath}/public/assets/js/jquery-validate/jquery.validate.js"></script>
<!-- Bootstrap 4 -->
<script src="${staticPath}/public/assets/js/bootstrap4/bootstrap.min.js"></script>
<script>

   function submit_btn(){
       $("#user-resetPassword").validate({
           rules:{
               oldPassword:{
                   required:true
               }
               ,newPassword:{
                   required: true,
                   minlength: 6,
                   maxlength: 20
               }
               ,confirmPassword: {
                   required: true,
                   equalTo: "#newPassword"
               },
           }
           ,messages:{
               oldPassword:{
                   required: "请输入原密码"
               }
               ,newPassword: {
                   required: "请输入新密码",
                   minlength: "密码不能小于6个字符",
                   maxlength: "密码不能大于20个字符"
               }
               ,confirmPassword: {
                   required: "请再次输入新密码",
                   equalTo: "两次密码输入不一致"
               }
           }

       })

    };

</script>
</body>
</html>
