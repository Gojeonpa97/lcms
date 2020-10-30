<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>admin</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${staticPath}/public/assets/css/fontawesome-free/all.min.css">
    <%--<link rel="stylesheet" href="${staticPath}/public/assets/css/fontawesome-free/fontawesome.min.css">--%>
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Tempusdominus Bootstrap 4 -->
    <link rel="stylesheet" href="${staticPath}/public/assets/css/tempusdominus-bootstrap-4/tempusdominus-bootstrap-4.min.css">
    <link rel="stylesheet" href="${staticPath}/public/assets/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
    <!-- 头部 -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
        </ul>
        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                    <i class="fas fa-expand-arrows-alt"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                    <i class="fas fa-th-large"></i>
                </a>
            </li>
        </ul>
    </nav>
    <!-- /头部结束 -->
    <!--左侧菜单 -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="index3.html" class="brand-link">
            <img src="../static/public/assets/images/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
            <span class="brand-text font-weight-light">Admin</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user panel (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="../static/public/assets/images/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <a href="/sys/profile" target="mainIndex" class="d-block">Alexander Pierce</a>
                    <%--<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>--%>
                    <%--<a href="#"><i class="fa fa-sign-out-alt text-danger"></i> 注销</a>--%>
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false" id="sidebar-menu">
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.左侧菜单 -->
    </aside>

    <!-- 右侧菜单 -->
    <div class="content-wrapper">
        <section class="content">
            <iframe src="" frameborder="0"  width="100%" height="100%" style="overflow-y :auto;" id="iframe" name="mainIndex"></iframe>
        </section>
    </div>
    <!-- 底部 -->
    <footer class="main-footer">
        <strong>Copyright &copy; 2014-2020 <a href="">Admin</a>.</strong>
        All rights reserved.
        <div class="float-right d-none d-sm-inline-block">
            <b>Version</b> 1.0.0
        </div>
    </footer>
</div>
<!-- jQuery -->
<script src="${staticPath}/public/assets/js/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="${staticPath}/public/assets/js/jquery-ui/jquery-ui.min.js"></script>
<script src="${staticPath}/public/assets/js/bootstrap4/bootstrap.bundle.min.js"></script>
<script>

    $(function() {

        setIframeHeight();

    });
    // 设置iframe高度
    function setIframeHeight() {
        // 设置iframe高度
        // $('#content-main').find('iframe').height($(window).height() - 92);
        var ifm= document.getElementById("iframe");
        ifm.height=document.documentElement.clientHeight-114;
    }

    //iframe自适应
    $(window).on('resize', function() {
        setIframeHeight();
    }).resize();

</script>
<script>

    var menuLi = '';
    $.ajax({
        type: 'POST',
        url: '/sys/menu/findAllMenuByUserId',
        data: '',
        success: function (data) {
            $.each(data.data ,function (index, menu){
                menuLi += '<li class="nav-item">';
                menuLi += '<a href="#" class="nav-link">';
                menuLi += '<i class="nav-icon fas fa-tachometer-alt"></i>';
                menuLi += '<p>'+menu.name+'<i class="right fas fa-angle-left"></i> </p></a>';
                if(menu.childrenMenus.length>0){
                    menuLi += '<ul class="nav nav-treeview">';
                    $.each(menu.childrenMenus, function (index, childrenMenu) {
                        menuLi += '<li class="nav-item">';
                        menuLi += '<a href="'+childrenMenu.url+'" target="mainIndex" class="nav-link">';
                        menuLi += '<i class="far fa-circle nav-icon"></i>';
                        menuLi += '<p>'+childrenMenu.name+'</p>';
                        menuLi += '</a></li>';
                    });
                    menuLi += '</ul>';
                }
                menuLi += '</li>';
            });
            $("#sidebar-menu").append(menuLi);
        },
        error: function (data) {
        }
    });
</script>
<script src="${staticPath}/public/assets/js/adminlte.js"></script>
<script>
    // $(function(){
    //     $('.sidebar li:not(.treeview) > a').on('click', function(){
    //         console.log($(this).parent())
    //         // var $parent = $(this).parent(".nav-item").find('> a').addClass('active')
    //         var $parent = $(this).parent().addClass('active');
    //
    //         $parent.siblings('.nav-item.active').find('> a').trigger('click');
    //         $parent.siblings().removeClass('active').find('li').removeClass('active');
    //     });
        // $(window).on('load', function(){
        //     $('.nav-sidebar a').each(function(){
        //         if(this.href === window.location.href){
        //             $(this).parent().addClass('active')
        //                 .closest('.treeview-menu').addClass('.menu-open')
        //                 .closest('.treeview').addClass('active');
        //         }
        //     });
        // });
    // });

</script>
</body>
</html>
