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
    <!-- Bootstrap-select 1.13.9 -->
    <link rel="stylesheet" href="${staticPath}/public/assets/css/bootstrap-select/bootstrap-select.min.css">
</head>
<body style="background-color: #f3f3f4;">
<div class="wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>角色管理</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">主页</a></li>
                        <li class="breadcrumb-item active">角色管理</li>
                    </ol>
                </div>
            </div>
        </div>
    </section>
    <div class="container-fluid">
            <div class="col-sm-12">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="card card-info">
                            <form class="form-inline" style="padding: 20px 0 20px 20px">
                                <div class="form-group">
                                    <label>角色名称：</label>
                                    <input type="text" class="form-control" id="name" name="name" placeholder="角色名称">
                                </div>
                                <div class="form-group" style="padding-left: 20px">
                                    <label>角色状态：</label>
                                    <select class="selectpicker" data-width="165px" id="roleStatus" name="roleStatus">
                                        <option class="" selected="selected" value="">请选择</option>
                                        <option value="正常">正常</option>
                                        <option value="停用">停用</option>
                                    </select>
                                </div>
                                <div class="form-group" style="padding-left: 20px">
                                    <a class="btn btn-primary btn-rounded" id="search"><i class="fa fa-search"></i>&nbsp;搜索</a>&nbsp;&nbsp;
                                    <a class="btn btn-warning btn-rounded" id="reset"><i class="fa fa-refresh"></i>&nbsp;重置</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="card">
                            <div class="btn-group-sm" id="toolbar">
                                <li class="btn btn-success" id="addRole"><i class="fa fa-plus"></i> 新增</li>
                                <li class="btn btn-danger" id="deleteRole"><i class="fa fa-remove"></i> 删除</li>
                            </div>
                            <div class="col-sm-12">
                                <table id="roleTable" class="table table-bordered table-hover">
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
<!-- Layui 2.5.6 -->
<script src="${staticPath}/common/layui/layui.all.js"></script>
<script src="${staticPath}/common/utils.js"></script>
<!-- Bootstrap-select 1.13.9 -->
<script src="${staticPath}/public/assets/js/bootstrap-select/bootstrap-select.min.js"></script>
<script>
var $table = $('#roleTable')
$(function () {

    $table.bootstrapTable({
        url: '/v1/system/role/roles',
        method: 'get',                      //请求方式（*）
        sidePagination: "server",
        pagination: true,
        paginationLoop: false,
        pageSize: 10,
        pageNumber: 1,
        pageList: [10, 25, 50],
        toolbar: "#toolbar",
        responseHandler:function(result){
            return{
                total: result.data.total,
                rows : result.data.records
            };
        },
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
            field: 'delFlag',
            title: '角色状态'
        },{
            field: 'createUser',
            title: '创建者'
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

    //删除
    function toDelete(sid){
        $.showConfirm('确定要删除吗？', function() {
            var params = [];
            params.push(sid);
            $.RestSyncAjax('/v1/system/role/delete','POST',params,function (result) {
                if(result.success){
                    $table.bootstrapTable('refresh');
                    $.showMessage('删除成功！', 'success');
                }
            });
        });
    }
    //批量删除
    $("#deleteRole").click(function () {
        var row = $table.bootstrapTable('getSelections');
        if(row.length == 0){
            $.showMessage('请选择数据！', 'error');
            // swal({text:"请选择数据！",type: "warning"});
            return false;
        }
        var params = [];
        $.each(row, function(k, v) {
            params.push(v.sid);
        });
        $.showConfirm('确定要删除吗？', function() {
            $.RestSyncAjax('/v1/system/role/delete','POST',params,function (result) {
                if(result.success){
                    $table.bootstrapTable('refresh');
                    swal({text:"删除成功！",type: "success"});
                }
            });
        });
    });
    //获取参数
    function getParams(params) {
        var param = {
            pageNum: params.offset / params.limit + 1,//当前页(开始页)
            pageSize: params.limit,//每页的数量
            delFlag: $("#roleStatus").val(),
            name: $("#name").val(),
        };
        return param;
    }
    //重置
    $("#reset").click(function () {
        $("#name").val("");
        $("#roleStatus").selectpicker('val','');
        $table.bootstrapTable('refresh');
    })
})

</script>
</body>
</html>
