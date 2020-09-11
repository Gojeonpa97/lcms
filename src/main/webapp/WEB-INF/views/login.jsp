<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>登入</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${staticPath}/common/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${staticPath}/common/style/admin.css" media="all">
    <link rel="stylesheet" href="${staticPath}/common/style/login.css" media="all">
</head>
<body>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>后台管理系统</h2>
        </div>
        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-username" ></label>
                <input type="text" name="username" id="username" lay-verify="username" placeholder="用户名" class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
                <input type="password" name="password" id="password" lay-verify="password" placeholder="密码" class="layui-input">
            </div>
            <div class="layui-form-item">
                <div class="layui-row">
                    <div class="layui-col-xs7">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
                        <input type="text" name="vercode" id="vercode" lay-verify="required" placeholder="图形验证码" class="layui-input">
                    </div>
                    <div class="layui-col-xs5">
                        <div style="margin-left: 10px;">
                            <img src="https://www.oschina.net/action/user/captcha" class="layadmin-user-login-codeimg" id="LAY-user-get-vercode">
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-form-item" style="margin-bottom: 20px;">
                <%--<input type="checkbox" name="remember" lay-skin="primary" title="记住密码">--%>
                <%--<a href="forget.html" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">忘记密码？</a>--%>
            </div>
            <div class="layui-form-item">
                <%--<button class="layui-btn layui-btn-fluid" onclick="login();">登 入</button>--%>
                <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit">登 入</button>
            </div>
            <div class="layui-trans layui-form-item layadmin-user-login-other">
                <a href="reg.html" class="layadmin-user-jump-change layadmin-link">注册帐号</a>
            </div>
        </div>
    </div>

    <div class="layui-trans layadmin-user-login-footer">

        <p>© 2018 <a href="" target="_blank">www.ormsts.cn</a></p>
    </div>
</div>

<script src="${staticPath}/common/layui/layui.js"></script>
<script>
    layui.config({
        base: '${staticPath}/' //静态资源所在路径
    }).extend({
        index: 'lib/index'
        ,login: 'sys/login/login' //主入口模块
    }).use(['index','login']);
</script>
</body>
</html>
