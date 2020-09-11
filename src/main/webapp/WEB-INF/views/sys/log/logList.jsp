<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>网站用户</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${staticPath}/common/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${staticPath}/common/style/admin.css" media="all">
</head>
<body>

<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-form layui-card-header layuiadmin-card-header-auto">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">ID</label>
                    <div class="layui-input-block">
                        <input type="text" name="id" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-block">
                        <input type="text" name="username" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">模块</label>
                    <div class="layui-input-block">
                        <input type="text" name="module" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">日志类型</label>
                    <div class="layui-input-block">
                        <select name="logType">
                            <option value="">不限</option>
                            <option value="登录日志">登录日志</option>
                            <option value="操作日志">操作日志</option>
                            <option value="异常日志">异常日志</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <button class="layui-btn layuiadmin-btn-useradmin" lay-submit lay-filter="LAY-user-front-search">
                        <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                    </button>
                </div>
            </div>
        </div>

        <div class="layui-card-body">
            <div style="padding-bottom: 10px;">
                <button class="layui-btn layui-btn-danger layui-btn-sm" data-type="batchdel"><i class="layui-icon layui-icon-delete"></i>删除</button>
            </div>

            <table id="LAY-user-manage" lay-filter="LAY-user-manage"></table>
            <script type="text/html" id="imgTpl">
                <img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
            </script>
            <script type="text/html" id="table-useradmin-webuser">
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
            </script>
        </div>
    </div>
</div>

<script src="${staticPath}/common/layui/layui.js"></script>
<script>
    layui.config({
        base: '${staticPath}/' //你存放新模块的目录，注意，不是layui的模块目录
    }).extend({
        log:'sys/log/log'
        ,index: 'common/js/lib/index' //主入口模块
    }).use('log','index'); //加载入口
</script>
</body>
</html>
