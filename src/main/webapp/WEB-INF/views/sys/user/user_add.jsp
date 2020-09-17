<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<html>
<head>
  <meta charset="utf-8">
  <title>添加用户</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="${staticPath}/common/layui/css/layui.css" media="all">
</head>
<body>

  <div class="layui-form" lay-filter="layuiadmin-form-useradmin" id="layuiadmin-form-useradmin" style="padding: 20px 0 0 0;">
  <div class="layui-form-item" style="display: none">
      <label class="layui-form-label">ID</label>
      <div class="layui-input-inline">
        <input type="text" value="${user.id }" name="id" autocomplete="off" class="layui-input">
      </div>
    </div>
  <div class="layui-form-item">
      <label class="layui-form-label">登录名称</label>
      <div class="layui-input-inline">
        <input type="text" value="${user.loginName }" name="loginName" lay-verify="required" placeholder="请输入登录名" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">用户名</label>
      <div class="layui-input-inline">
        <input type="text" value="${user.username }" name="username" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">密码</label>
      <div class="layui-input-inline">
        <input type="password" value="${user.password }" name="password" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
      </div>
    </div>
    <c:choose>
    	<c:when test="${user.id != null}">
    		<div class="layui-form-item" lay-filter="sex" style="display: none">
      			<label class="layui-form-label">选择性别</label>
      			  <div class="layui-input-block">
        			<input type="radio" name="sex" value="0" title="男">
        			<input type="radio" name="sex" value="1" title="女">
      			  </div>
    	    </div>
    	</c:when>
    	<c:otherwise>
    		<div class="layui-form-item" lay-filter="sex">
      			<label class="layui-form-label">选择性别</label>
      			  <div class="layui-input-block">
        			<input type="radio" name="sex" value="0" title="男">
        			<input type="radio" name="sex" value="1" title="女">
      			  </div>
    	    </div>
    	</c:otherwise>
    </c:choose>
    <div class="layui-form-item">
      <label class="layui-form-label">邮箱</label>
      <div class="layui-input-inline">
        <input type="text" value="${user.email }" name="email" lay-verify="email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">手机号码</label>
      <div class="layui-input-inline">
        <input type="text" value="${user.phonenumber }" name="phonenumber" lay-verify="phone" placeholder="请输入号码" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">具体描述</label>
      <div class="layui-input-inline">
        <input type="text" value="${user.description }" name="description" lay-verify="required" placeholder="请输入具体描述" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item layui-hide">
      <input type="button" lay-submit lay-filter="LAY-user-front-submit" id="LAY-user-front-submit" value="确认">
    </div>
  </div>

<script src="${staticPath}/common/layui/layui.js"></script>
  <script>
   layui.config({
    base: '${staticPath}/' //静态资源所在路径
  }).extend({
    index: 'common/js/lib/index' //主入口模块
  }).use(['index','form'],function (){
	  var $ = layui.$
	    ,form = layui.form;
  });
  </script>
</body>
</html>