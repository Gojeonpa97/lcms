<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>角色管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${staticPath}/common/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${staticPath}/common/style/admin.css" media="all">
    <script src="${staticPath}/public/js/jquery-1.9.1.min.js"></script>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-form layui-card-header layuiadmin-card-header-auto">
            <div class="layui-form-item">
                <div class="layui-inline">
                    角色筛选
                </div>
                <div class="layui-inline">
                    <select name="name" lay-filter="LAY-user-adminrole-type">
                        <option value="">全部角色</option>
                        <option value="0">管理员</option>
                        <option value="1">超级管理员</option>
                        <option value="2">纠错员</option>
                        <option value="3">采购员</option>
                        <option value="4">推销员</option>
                        <option value="5">运营人员</option>
                        <option value="6">编辑</option>
                    </select>
                </div>
                <div class="layui-inline">
                    <button class="layui-btn layuiadmin-btn-useradmin" lay-submit lay-filter="LAY-role-front-search">
                        <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                    </button>
                </div>
            </div>
        </div>
        <div class="layui-card-body">
            <div style="padding-bottom: 10px;">
                <button class="layui-btn layuiadmin-btn-role" data-type="batchdel">删除</button>
                <button class="layui-btn layuiadmin-btn-role" data-type="add">添加</button>
            </div>

            <table id="LAY-user-back-role" lay-filter="LAY-user-back-role"></table>
            <script type="text/html" id="buttonTpl">
                {{#  if(d.check == true){ }}
                <button class="layui-btn layui-btn-xs">已审核</button>
                {{#  } else { }}
                <button class="layui-btn layui-btn-primary layui-btn-xs">未审核</button>
                {{#  } }}
            </script>
            <script type="text/html" id="table-useradmin-admin">
                <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
            </script>
        </div>
    </div>
</div>
<script type="text/html" id="statusTpl">
    <input type="checkbox" name="status" value="{{d.id}}" lay-skin="switch" lay-text="启用|禁用" lay-filter="sexDemo" {{ d.status == 0 ? 'checked' : '' }}>
</script>
<script src="${staticPath}/common/layui/layui.js"></script>
<script>
    layui.config({
        base: '${staticPath}/sys/role/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use('role'); //加载入口
</script>

</body>
</html>
