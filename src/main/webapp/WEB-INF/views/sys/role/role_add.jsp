<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>添加角色</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${staticPath}/common/layui/css/layui.css" media="all">
</head>
<style>
    .layui-input.layui-unselect{
        padding-right: 8px;
    }
</style>
<body>

<div class="layui-form" lay-filter="layuiadmin-form-useradmin" id="layuiadmin-form-useradmin" style="padding: 20px 0 0 0;">
    <div class="layui-form-item" style="display: none">
        <label class="layui-form-label">ID</label>
        <div class="layui-input-inline">
            <input type="text" value="${sysRole.id }" name="id" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">选择角色</label>
        <div class="layui-inline">
            <select name="name" value="${sysRole.name}">
                <option value="0" <c:if test="${'0' eq sysRole.name}">selected</c:if>>管理员</option>
                <option value="1" <c:if test="${'1' eq sysRole.name}">selected</c:if>>超级管理员</option>
                <option value="2" <c:if test="${'2' eq sysRole.name}">selected</c:if>>纠错员</option>
                <option value="3" <c:if test="${'3' eq sysRole.name}">selected</c:if>>采购员</option>
                <option value="4" <c:if test="${'4' eq sysRole.name}">selected</c:if>>推销员</option>
                <option value="5" <c:if test="${'5' eq sysRole.name}">selected</c:if>>运营人员</option>
                <option value="6" <c:if test="${'6' eq sysRole.name}">selected</c:if>>编辑</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">具体描述</label>
        <div class="layui-input-inline">
            <input type="text" value="${sysRole.description}" name="description" lay-verify="required" placeholder="请输入具体描述" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-hide">
        <input type="button" lay-submit lay-filter="LAY-role-front-submit" id="LAY-role-front-submit" value="确认">
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