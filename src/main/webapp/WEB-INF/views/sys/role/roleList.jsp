<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>角色管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${staticPath}/public/assets/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${staticPath}/public/assets/css/bootstrap-table/bootstrap-table.min.css">
    <link rel="stylesheet" href="${staticPath}/public/assets/css/fontawesome-free/all.min.css">
    <link rel="stylesheet" href="${staticPath}/public/assets/css/fontawesome-free/v4-shims.min.css">
    <link rel="stylesheet" href="${staticPath}/public/assets/css/adminlte.min.css">
</head>
<body>
<div class="wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Profile</h1>
                </div>
<<<<<<< Updated upstream
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
=======
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">User Profile</li>
                    </ol>
>>>>>>> Stashed changes
                </div>
                <div class="layui-inline">
                    <button class="layui-btn layuiadmin-btn-useradmin" lay-submit lay-filter="LAY-role-front-search">
                        <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                    </button>
                </div>
            </div>
        </div>
    </section>
    <div class="container-fluid">
            <div class="col-sm-12">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="card">
                            <div class="btn-group-sm" id="toolbar">
                                <li class="btn btn-success" id="addUser"><i class="fa fa-plus"></i> 新增</li>
                                <li class="btn btn-danger" id="deleteUser"><i class="fa fa-remove"></i> 删除</li>
                            </div>
                            <div class="col-sm-12">
                                <table id="user-name-label" class="table table-bordered table-hover">
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </div>
</div>
<script src="${staticPath}/public/assets/js/jquery/jquery.min.js"></script>
<script src="${staticPath}/public/assets/js/bootstrap/bootstrap.min.js"></script>
<script src="${staticPath}/public/assets/js/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${staticPath}/public/assets/js/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
<script src="${staticPath}/common/layui/layui.all.js"></script>
<script>
    $('#user-name-label').bootstrapTable({
        url: '/v1/system/role/roles',
        method: 'get',                      //请求方式（*）
        sidePagination: "server",
        pagination: true,
        paginationLoop: false,
        pageSize: 10,
        pageNumber: 1,
        pageList: [10, 25, 50],
        toolbar: "#toolbar",
        queryParams:getParams,
        columns: [{
            checkbox: true
        },{
            field: 'sid',
            title: 'ID'
        },{
            field: 'name',
            title: '角色名'
        },{
            field: 'sort',
            title: '顺序'
        },{
            field: 'status',
            title: '角色状态'
        },{
            field: 'createUser',
            title: '创建者'
        },{
            field: 'createTime',
            title: '创建时间'
        },{
            field: 'createTime',
            title: '创建时间'
        },{
            title: '具体描述',
            align: 'description',

        },{
            title: '操作',
            align: 'center',
            formatter: function (value, row, index) {
                var _button = '';
                    _button += '<a class="btn btn-success btn-xs" href="javascript:void(0)" onclick="toEdit(\'' + row.sid + '\')"><i class="fa fa-edit"></i>编辑</a> '+
                               '<a class="btn btn-danger btn-xs" href="javascript:void(0)" onclick="toDelete(\'' + row.sid + '\')"><i class="fa fa-remove"></i>删除</a>'+
                               '<a class="btn btn-info btn-xs" href="javascript:void(0)" onclick="setRoles(\'' + row.sid + '\')"><i class="fa fa-key"></i>分配角色</a>';
                return _button;
            }
        }]
    });
    //获取参数
    function getParams(params) {
        console.log(params);
        var temp = {
            pageSize : params.offset,
            pageNum : params.limit
        };
        return temp;
    }
</script>
</body>
</html>
