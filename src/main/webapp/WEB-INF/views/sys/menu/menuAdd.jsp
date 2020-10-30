    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ include file="/WEB-INF/views/base/sys_tag.jsp" %>
        <html>
        <head>
        <meta charset="utf-8">
        <title>网站用户</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,
        user-scalable=0">
        <link rel="stylesheet" href="${staticPath}/public/assets/css/fontawesome-free/all.min.css">
        <link rel="stylesheet" href="${staticPath}/public/assets/css/adminlte.min.css">
        <link rel="stylesheet" href="${staticPath}/public/assets/css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="${staticPath}/public/assets/css/ztree/zTreeStyle/zTreeStyle.css">
        <%--<link rel="stylesheet" href="${staticPath}/common/layui/css/layui.css" media="all">--%>

        </head>
        <body>
        <div class="wrapper">
        <div class="container-fluid" style="padding: 20px 0 0 20px;">
        <div class="row">
        <div class="col-md-6">
        <form class="form-horizontal" id="addTplForm">
        <div class="form-group row">
        <label class="col-sm-2 col-form-label">上级菜单：</label>
        <div class="col-sm-8">
        <div class="input-group">
        <input type="text" class="form-control" readonly="true" name="loginName" onclick="showMenu();" id="loginname"
        placeholder="登录账号" required>
        <span class="input-group-addon"><i class="fa fa-search"></i></span>
        </div>
        </div>
        </div>

        </form>
            <ul id="tree" class="tree"></ul>
        </div>
        </div>
        </div>
        </div>
        <script src="${staticPath}/public/assets/js/jquery/jquery.min.js"></script>
        <%--<script src="${staticPath}/public/assets/js/ztree/jquery.ztree.all.js"></script>--%>
        <script src="${staticPath}/public/assets/js/ztree/jquery.ztree.core.js"></script>
        <script>
        function showMenu() {

        var setting ={
        simpleData: {
        enable: true,
        idKey: "sid",
        pIdKey: "pid",
        rootPId: 0
        },
        data:{
        key:{
        children:"childrenMenus"
        }
        }
        };

        $.ajax({
        type: "post",
        url: "/sys/menu/findAllMenuByUserId",
        dataType: "json",
        success: function(data){
        $.fn.zTree.init($("#tree"), setting, data.data);
        }
        })
        }
        </script>
        </body>

        </html>
