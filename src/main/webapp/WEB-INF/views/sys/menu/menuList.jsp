<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>网站用户</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
        <link type="text/css" rel="stylesheet" href="${staticPath}/common/layui/css/layui.css" >
        <%--<link type="text/css" rel="stylesheet" href="${staticPath}/common/style/admin.css" >--%>
        <link type="text/css" rel="stylesheet" href="${staticPath}/lib/treetable-lay/treetable.css" >
     </head>
<body>
    <div class="layui-fluid">
        <div class="layui-card">
            <div class="layui-card-body">
                <div style="padding-bottom: 10px;">
                    <div class="layui-btn-group">
                        <button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon">&#xe654;</i>新增</button>
                        <button class="layui-btn layui-btn-sm" lay-event="updata"><i class="layui-icon">&#xe642;</i>修改</button>
                        <button class="layui-btn layui-btn-sm" lay-event="delete"><i class="layui-icon">&#xe640;</i>删除</button>
                        <button class="layui-btn layui-btn-sm" lay-event="refresh"><i class="layui-icon">&#xe666;</i>刷新</button>
                    </div>
                </div>
                    <table class="layui-hide" id = "menu" lay-filter="menu"></table>
                    <script type="text/html" id="table-useradmin-webuser">
                        <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
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
        index: 'lib/index' //主入口模块
         ,treetable:'lib/treetable-lay/treetable'
         ,menu:'sys/menu/menu'
    }).use(['index','treetable','layer','menu']);

</script>
<style>
    .layui-table-tool{
    display: none;
    }
</style>
</body>
</html>
