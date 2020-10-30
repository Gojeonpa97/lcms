<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<html>
    <head>
        <meta charset="utf-8">
        <title>网站用户</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">

        <link rel="stylesheet" href="${staticPath}/public/assets/css/fontawesome-free/all.min.css">
        <link rel="stylesheet" href="${staticPath}/public/assets/css/adminlte.min.css">
        <link rel="stylesheet" href="${staticPath}/public/assets/css/bootstrap/bootstrap.min.css">
        <!-- Font Awesome Icons -->
        <link rel="stylesheet" href="${staticPath}/public/assets/css/fontawesome-free/all.min.css">
        <link rel="stylesheet" href="${staticPath}/public/assets/css/fontawesome-free/v4-shims.min.css">
        <link rel="stylesheet" href="${staticPath}/public/assets/css/bootstrap-table/bootstrap-table.min.css">
        <link rel="stylesheet" href="${staticPath}/public/assets/css/treegrid/jquery.treegrid.css">
    </head>
<body>
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
                <div class="card">
                    <form id="menu-form">

                    </form>
                    <div class="col-sm-12 select-table table-striped">
                        <table id="bootstrap-tree-table"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>

    <script src="${staticPath}/public/assets/js/jquery/jquery.min.js"></script>
    <script src="${staticPath}/public/assets/js/bootstrap-table/bootstrap-table.js"></script>
    <script src="${staticPath}/public/assets/js/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
    <script src="${staticPath}/public/assets/js/bootstrap-table/extensions/treegrid/bootstrap-table-treegrid.js"></script>
    <script src="${staticPath}/public/assets/js/jquery-treegrid/jquery.treegrid.js"></script>
    <!-- Layui 2.5.6 -->
    <script src="${staticPath}/common/layui/layui.all.js"></script>
    <script src="${staticPath}/common/utils.js"></script>
<script>
    var $table = $('#bootstrap-tree-table');
    $(function () {
    $table.bootstrapTable({
        url:'/sys/menu/findAllMenu',
        type:'POST',
        contentType:'application/json;charse=UTF-8',

        idField: 'sid',
        sidePagination: "server",
        pageSize: 10,              //每页的记录行数（*）
        pageNumber: 1,             //初始化加载第一页，默认第一页
        responseHandler:function(result){
            return{
                rows : result.data
            };
        },
        queryParams:searchParam ,  //传递参数（*）
        columns: [ {
            field: 'check',
            radio: true,
        } ,{
            field: 'name',
            title: '菜单名称'
        } ,{
            field: 'url',
            title: '地址'
        } ,{
            field: 'icon',
            title: '图标'
        } ,{
            field: 'status',
            title: '状态', sortable: true,  align: 'center'
        }, {
            field: 'sort',
            title: '排序'
        }, {
            title: '操作',
            align: 'center',
            formatter: function (value, row, index) {
                var _button = '';
                _button += '<a class="btn btn-success btn-xs" href="javascript:void(0)" onclick="toEdit(\'' + row.sid + '\')"><i class="fa fa-edit"></i>&nbsp;编辑</a> '+
                            '<a class="btn btn-info btn-xs " href="javascript:void(0)" onclick="toAdd(\'' + row.sid + '\')"><i class="fa fa-plus"></i>新增</a> '+
                            '<a class="btn btn-danger btn-xs" href="javascript:void(0)" onclick="toDelete(\'' + row.sid + '\')"><i class="fa fa-trash"></i>&nbsp;删除</a>';
                return _button;
            }
        }],

    // bootstrap-table-treegrid.js 插件配置 -- start
    //在哪一列展开树形
    treeShowField: 'name',
    //指定父id列
    parentIdField: 'pid',
    onResetView: function(data) {
    $table.treegrid({
    initialState: 'collapsed',// 所有节点都折叠
    // initialState: 'expanded',// 所有节点都展开，默认展开
    treeColumn: 1,
    expanderExpandedClass: 'glyphicon glyphicon-chevron-down', // 展开的按钮的图标
    expanderCollapsedClass: 'glyphicon glyphicon-chevron-right', // 缩起的按钮的图标
    onChange: function() {
    // $table.bootstrapTable('resetWidth');
    }
    });
    //只展开树形的第一级节点
    // $table.treegrid('getRootNodes').treegrid('expand');
    console.log($table.treegrid('getRootNodes'))
    console.log($table.treegrid('expand'))
    $table.treegrid('getRootNodes').treegrid('expand');
    },
    onCheck:function(row){
    var datas = $table.bootstrapTable('getData');
    // 勾选子类
    selectChilds(datas,row,"id","pid",true);

    // 勾选父类
    selectParentChecked(datas,row,"id","pid")

    // 刷新数据
    $table.bootstrapTable('load', datas);
    },

    onUncheck:function(row){
    var datas = $table.bootstrapTable('getData');
    selectChilds(datas,row,"id","pid",false);
    $table.bootstrapTable('load', datas);
    },
    // bootstrap-table-treetreegrid.js 插件配置 -- end

    });
    });
    //搜索条件
function searchParam(params) {
    console.log(params)
    var params = {
        pageNum: params.offset / params.limit + 1,//当前页(开始页)
        pageSize: params.limit,//每页的数量
        loginName: $("#loginName").val(),
        username: $("#username").val(),
    };
    return params;
};
function toAdd() {
    var url = '/sys/menuadd';
    var layerIndex = layer.open({
        type: 2,
        title: '添加菜单',
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
</script>
</body>
</html>
