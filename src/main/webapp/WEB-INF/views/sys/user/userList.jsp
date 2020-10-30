<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>网站用户</title>
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
</head>
<body style="background-color: #f3f3f4;">
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
        </div>
    </section>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-12">
                <div class="card card-info">
                    <form class="form-inline" style="padding: 20px 0 20px 20px">
                        <div class="form-group">
                            <label>登录名称：</label>
                            <input type="text" class="form-control" id="loginName" name="loginName" placeholder="登录名称">
                        </div>
                        <div class="form-group" style="padding-left: 20px">
                            <label>用户名称：</label>
                            <input type="text" class="form-control" id="username" name="username" placeholder="用户名称">
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
                            <li class="btn btn-success" id="addUser"><i class="fa fa-plus"></i> 新增</li>
                            <li class="btn btn-danger" id="deleteUser"><i class="fa fa-trash"></i> 删除</li>
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
<!-- jQuery 3 -->
<script src="${staticPath}/public/assets/js/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${staticPath}/public/assets/js/bootstrap/bootstrap.min.js"></script>
<!-- Bootstrap-table 1.18.0 -->
<script src="${staticPath}/public/assets/js/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${staticPath}/public/assets/js/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
<!-- Layui 2.5.6 -->
<script src="${staticPath}/common/layui/layui.all.js"></script>
<!-- Sweetalert2 10.7.0 -->
<script src="${staticPath}/public/assets/js/sweetalert/sweetalert2.js"></script>
<script src="${staticPath}/common/utils.js"></script>
<!-- jQuery-validate 1.19.2 -->
<script src="${staticPath}/public/assets/js/jquery-validate/jquery.validate.js"></script>
<script src="${staticPath}/public/assets/js/jquery-validate/localization/messages_zh.js"></script>
<script >
    $('#user-name-label').bootstrapTable({
        sidePagination: "server",  //分页方式：client客户端分页，server服务端分页（*）
        pagination: true,          //是否显示分页（*）
        paginationLoop: false,
        pageSize: 10,              //每页的记录行数（*）
        pageNumber: 1,             //初始化加载第一页，默认第一页
        pageList:[10,25,50,100],   //可供选择的每页的行数（*）
        escape: true,
        showPageGo: true,
        rememberSelected: true,
        toolbar: "#toolbar",        //工具按钮用哪个容器
        ajax:function(params){
            $.RestSyncAjax('/v1/system/user/queryUsers','POST',params.data,function (result) {
                if(result.success){
                    params.success({
                        total: result.data.total,
                        rows : result.data.records
                    });
                }
            });
        },
        queryParams:searchParam ,  //传递参数（*）
        columns: [{
            checkbox: true
        },{
            field: 'sid',
            title: 'ID'
        },{
            field: 'loginName',
            title: '登录名称'
        },{
            field: 'username',
            title: '用户名称'
        },{
            field: 'email',
            title: '邮箱'
        },{
            field: 'phonenumber',
            title: '手机'
        },{
            field: 'delFlag',
            title: '用户状态',
            formatter: function (value, row, index) {
                return statusTools(row);
            }
        },{
            field: 'createTime',
            title: '创建时间'
        },{
            title: '操作',
            align: 'center',
            formatter: function (value, row, index) {
                var _button = '';
                _button += '<a class="btn btn-success btn-xs" href="javascript:void(0)" onclick="toEdit(\'' + row.sid + '\')"><i class="fa fa-edit"></i>编辑</a> '+
                           '<a class="btn btn-danger btn-xs" href="javascript:void(0)" onclick="toDelete(\'' + row.sid + '\')"><i class="fa fa-remove"></i>删除</a>'+
                           '<a class="btn btn-warning btn-xs" href="javascript:void(0)" onclick="resetPwd(\'' + row.sid + '\')"><i class="fa fa-key"></i>重置密码</a>'+
                           '<a class="btn btn-info btn-xs" href="javascript:void(0)" onclick="setRoles(\'' + row.sid + '\')"><i class="fa fa-key"></i>分配角色</a>';
                return _button;
            }
        }]
    });

    // 添加用户
    $("#addUser").click(function () {
        var url = '/sys/userAdd';
        var layerIndex = layer.open({
            type: 2,
            title: '添加用户',
            resize: false,
            shadeClose: true,
            area: ['600px', '550px'],
            content: [url, 'no'],
            btn: ['保存', '取消'],
            yes: function (index, layero) {
                var addTplForm = layer.getChildFrame('#addTplForm', index);
                if($(addTplForm).valid()){
                    var addParam = {};
                    addParam.loginName = layer.getChildFrame('#loginname', index).val();
                    addParam.username = layer.getChildFrame('#username', index).val();
                    addParam.email = layer.getChildFrame('#email', index).val();
                    addParam.phonenumber = layer.getChildFrame('#phonenumber', index).val();
                    $.RestSyncAjax('/v1/system/user/insert','POST',addParam,function (result) {
                        if(result.success){
                            $.showMessage("添加用户成功", "success");
                            $('#user-name-label').bootstrapTable('refresh');//刷新表格
                            layer.close(index); //关闭弹层
                        }
                    });
                }
            },success:function (layero, index) {
                var addTplForm = layer.getChildFrame('#addTplForm', index);
                $(addTplForm).validate({
                    rules: {
                        username: {
                            required: true,
                            maxlength:30,
                            // remote:{
                            //     url:"/v1/system/user/queryUsers",
                            //     type:"POST",
                            //     headers: {
                            //         "Content-Type": "application/json;charse=UTF-8"
                            //     },
                            //     data:{
                            //         username: function () {
                            //             return $("#username").val()
                            //         }
                            //     }
                            // }
                        },
                        email: {
                            maxlength:30,
                            required:true,
                            email:true
                        }
                    },
                    messages: {
                        username: {
                            maxlength:"用户名最大长度为30位！",
                            required:"用户名不能为空！",
                            isUserName:"只能输入中英文、数字！"
                        },
                        email:{
                            required:"邮箱不能为空！"
                        }
                    },
                    focusCleanup: true,
                    // errorElement: 'span',
                    // errorPlacement: function (error, element) {
                    //     console.log(element);
                    //     console.log(error);
                    //     error.addClass('invalid-feedback');
                    //     element.closest('.form-group').append(error);
                    // },
                    highlight: function (element, errorClass, validClass) {
                        $(element).addClass('is-invalid');
                    },
                    unhighlight: function (element, errorClass, validClass) {
                        $(element).removeClass('is-invalid');
                    }
                });
            }
        })
    });

//搜索条件
function searchParam(params) {
    var params = {
        pageNum: params.offset / params.limit + 1,//当前页(开始页)
        pageSize: params.limit,//每页的数量
        loginName: $("#loginName").val(),
        username: $("#username").val(),
    };
    return params;
};
//重置密码
function resetPwd(rowId) {
    $.showConfirm("确定要重置该用户的密码吗？", function (layerIndex) {
        var param;
        param = [rowId];
            $.ajax({
                type:"post",
                url:"/v1/system/user/pwdReset",
                data:JSON.stringify(param),
                headers: {
                        "Content-Type": "application/json;charse=UTF-8"
                },
                success:function(data){
                    if(data.success){
                        $.showMessage("重置成功", "success");
                        $('#user-name-label').bootstrapTable('refresh');
                    }
                }
            });
    });
};

//分配角色
function setRoles(sid) {
    var url = '/sys/userAddRole?sid='+sid;
    var layerIndex = layer.open({
        type: 2,
        title: '分配角色',
        resize: false,
        shadeClose: true,
        area: ['600px', '550px'],
        content: [url, 'no'],
        btn: ['保存', '取消'],
        yes: function (index, layero) {

        }, btn2: function (index, layero) {
        }
    })
};

//删除
function toDelete(sid) {
    $.showConfirm('确定要删除吗？', function() {
        var params = [];
        params.push(sid);
        $.RestSyncAjax('/v1/system/user/delete','POST',params,function (result) {
            if(result.success){
                $('#user-name-label').bootstrapTable('refresh');
                $.showMessage('删除成功！', 'success');
            }
        });
    });
};

//修改
function toEdit(sid) {
    var url = '/sys/userupdate?sid='+sid;
    var layerIndex = layer.open({
        type: 2,
        title: '修改用户',
        resize: false,
        shadeClose: true,
        area: ['600px', '550px'],
        content: [url, 'no'],
        btn: ['保存', '取消'],
        yes: function (index, layero) {
            var addTplForm = layer.getChildFrame('#addTplForm', index);
            var editParam = {};
            editParam.sid = sid;
            editParam.loginname = layer.getChildFrame('#loginname', index).val();
            editParam.username = layer.getChildFrame('#username', index).val();
            editParam.email = layer.getChildFrame('#email', index).val();
            editParam.phonenumber = layer.getChildFrame('#phonenumber', index).val();
            $.RestSyncAjax('/v1/system/user/update','POST',editParam,function (result) {
                if(result.success){
                    $('#user-name-label').bootstrapTable('refresh');
                    layer.close(index); //关闭弹层
                    $.showMessage('修改成功！', 'success');
                }
            });
        },
        btn2: function (index, layero) {
        }
    });
};

//批量删除
$("#deleteUser").click(function () {
    var row = $('#user-name-label').bootstrapTable('getSelections');
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
        $.RestSyncAjax('/v1/system/user/delete','POST',params,function (result) {
            if(result.success){
                $('#user-name-label').bootstrapTable('refresh');
                swal({text:"删除成功！",type: "success"});
            }
        });
    });
});

//模糊查询
$("#search").click(function () {
    $('#user-name-label').bootstrapTable('refresh');
});

//角色状态显示
function statusTools(row) {
    if (row.status == 1) {
        return '<i class="fa fa-toggle-off text-info fa-2x" onclick=""></i>';
    } else {
        return '<i class="fa fa-toggle-on text-info fa-2x" onclick=""></i>';
    }
}
</script>
</body>
</html>
