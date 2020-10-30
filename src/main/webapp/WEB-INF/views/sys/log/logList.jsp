<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>系统日志</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="${staticPath}/public/assets/css/bootstrap/bootstrap.min.css">
    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="${staticPath}/public/assets/css/fontawesome-free/all.min.css">
    <link rel="stylesheet" href="${staticPath}/public/assets/css/fontawesome-free/v4-shims.min.css">
    <link rel="stylesheet" href="${staticPath}/public/assets/css/adminlte.min.css">
    <!-- Sweetalert2 10.7.0 -->
    <link rel="stylesheet" href="${staticPath}/public/assets/css/sweetalert2/sweetalert2.css">
    <!-- Bootstrap-table 1.5.3 -->
    <link rel="stylesheet" href="${staticPath}/public/assets/css/bootstrap-table/bootstrap-table.min.css">
    <!-- Bootstrap-select 1.13.9 -->
    <link rel="stylesheet" href="${staticPath}/public/assets/css/bootstrap-select/bootstrap-select.min.css">
</head>
<body style="background-color: #f3f3f4;">

<div class="wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>System</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">System</a></li>
                        <li class="breadcrumb-item active">Log</li>
                    </ol>
                </div>
            </div>
        </div>
    </section>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-12">
                <div class="card card-info">
                    <form class="form-inline" style="padding: 20px 0 20px 20px">
                        <div class="form-group">
                            <label>模块：</label>
                            <input type="text" class="form-control" id="module" name="module" placeholder="模块">
                        </div>
                        <div class="form-group" style="padding-left: 20px">
                            <label>日志类型：</label>
                            <select class="selectpicker" data-width="165px" id="logType" name="logType">
                                <option class="" selected="selected" value="">请选择</option>
                                <option value="登录日志">登录日志</option>
                                <option value="操作日志">操作日志</option>
                                <option value="异常日志">异常日志</option>
                            </select>
                            <%--<input type="text" class="form-control" id="username" name="username" placeholder="日志类型">--%>
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
                        <li class="btn btn-danger" id="deleteLog"><i class="fa fa-trash"></i> 删除</li>
                    </div>
                    <div class="col-sm-12">
                        <table id="logTable" class="table table-bordered table-hover">
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery 3 -->
<script src="${staticPath}/public/assets/js/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${staticPath}/public/assets/js/bootstrap/bootstrap.min.js"></script>
<!-- Bootstrap-table 1.18.0 -->
<script src="${staticPath}/public/assets/js/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${staticPath}/public/assets/js/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
<!-- Bootstrap-select 1.13.9 -->
<script src="${staticPath}/public/assets/js/bootstrap-select/bootstrap-select.min.js"></script>
<!-- Layui 2.5.6 -->
<script src="${staticPath}/common/layui/layui.all.js"></script>
<script src="${staticPath}/common/utils.js"></script>
<script>
var $table = $('#logTable');
$(function () {
    $table.bootstrapTable({
        url:'/v1/system/log/queryLogs',
        method:'GET',
        contentType:'application/json;charse=UTF-8',
        sidePagination: "server",  //分页方式：client客户端分页，server服务端分页（*）
        pagination: true,          //是否显示分页（*）
        paginationLoop: false,
        pageSize: 10,              //每页的记录行数（*）
        pageNumber: 1,             //初始化加载第一页，默认第一页
        pageList:[10,25,50,100],   //可供选择的每页的行数（*）
        escape: true,
        showPageGo: true,
        rememberSelected: true,
        toolbar: "#toolbar",
        responseHandler:function(result){
            return{
                total: result.data.total,
                rows : result.data.records
            };
        },
        queryParams:searchParam ,  //传递参数（*）
        columns: [{
            checkbox: true
        },{
            field: 'id',
            title: 'ID'
        },{
            field: 'userName',
            title: '创建人'
        },{
            field: 'content',
            title: '操作内容',
            width: '600'
        },{
            field: 'ip',
            title: '请求地址'
        },{
            field: 'module',
            title: '模块'
        },{
            field: 'os',
            title: '操作系统'
        },{
            field: 'createTime',
            title: '创建时间'
        },{
            field: 'description',
            title: '描述'
        },{
            title: '操作',
            align: 'center',
            width:'100',
            formatter: function (value, row, index) {
                var _button = '';
                    _button += '<a class="btn btn-danger btn-xs" href="javascript:void(0)" onclick="toDelete(\'' + row.sid + '\')"><i class="fa fa-remove"></i>删除</a>';
                return _button;
            }
        }]
    });
    //搜索条件
    function searchParam(params) {
        var params = {
            pageNum: params.offset / params.limit + 1,//当前页(开始页)
            pageSize: params.limit,//每页的数量
            module: $("#module").val(),
            logType: $("#logType").val(),
        };
        return params;
        // return JSON.stringify(params);
    };
    //删除
    function toDelete(sid){
        $.showConfirm('确定要删除吗？', function() {
            var params = [];
            params.push(sid);
            $.RestSyncAjax('/v1/system/log/deleteLog','POST',params,function (result) {
                if(result.success){
                    $table.bootstrapTable('refresh');
                    $.showMessage('删除成功！', 'success');
                }
            });
        });
    }

    //批量删除
    $("#deleteLog").click(function () {
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
        console.log(params)
        $.showConfirm('确定要删除吗？', function() {
            $.RestSyncAjax('/v1/system/log/deleteLog','POST',params,function (result) {
                if(result.success){
                    $table.bootstrapTable('refresh');
                    swal({text:"删除成功！",type: "success"});
                }
            });
        });
    });
    //模糊查询
    $("#search").click(function () {
        $table.bootstrapTable('refresh');
    });
    //重置
    $("#reset").click(function () {
        $("#module").val("");
        $("#logType").selectpicker('val','');
        $table.bootstrapTable('refresh');
    })
})
</script>
</body>
</html>
