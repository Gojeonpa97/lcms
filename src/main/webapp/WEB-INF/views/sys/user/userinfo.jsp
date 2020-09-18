
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>设置我的资料</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${staticPath}/common/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${staticPath}/common/style/admin.css" media="all">
    <link rel="stylesheet" href="${staticPath}/common/style/template.css" media="all">
</head>
<body>
<div class="layui-fluid layadmin-homepage-fluid">
    <div class="layui-row layui-col-space8">
        <!-- 左 -->
        <div class="layui-col-md3">
            <div class="layadmin-homepage-panel layadmin-homepage-shadow">
                <div class="layui-card text-center">
                    <div class="layui-card-header"><h3>个人资料</h3></div>
                    <div class="layui-card-body" >
                        <div class="layadmin-homepage-pad-ver">
                            <img class="layadmin-homepage-pad-img" src="/pages/layuiadmin/style/res/template/portrait.png" width="96" height="96">
                        </div>
                        <h4 class="layadmin-homepage-font">胡歌</h4>
                        <p class="layadmin-homepage-min-font">中国知名演员</p></div>


                </div>
                <div class="layadmin-homepage-pad-ver">
                    <div class="bd-list">
                        <div class="bd-list-item">
                            <div class="bd-list-item-content">
                                <div class="bd-list-item-text">登录名称：</div>
                            </div>
                            <div class="bd-list-item-oper">修改</div>
                        </div>
                        <div class="bd-list-item">
                            <div class="bd-list-item-content">
                                <div class="bd-list-item-text">手机号码：</div>
                            </div>
                            <div class="bd-list-item-oper">修改123</div>
                        </div>
                        <div class="bd-list-item">
                            <div class="bd-list-item-content">
                                <div class="bd-list-item-text">邮箱地址：</div>
                            </div>
                            <div class="bd-list-item-oper">修1改</div>
                        </div>
                        <div class="bd-list-item">
                            <div class="bd-list-item-content">
                                <div class="bd-list-item-text">创建时间：</div>
                            </div>
                            <div class="bd-list-item-oper">1修改</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 右 -->
        <div class="layui-col-sm12 layui-col-md9">
            <div class="layui-card">
                <div class="layui-card-body layui-text">
                    <div class="layui-card-header">
                        <ul class="layui-tab-title">
                            <li class="layui-this">基本信息</li>
                            <li>其他</li>
                        </ul>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
<style>







    .info-list-item > .layui-icon {
        position: absolute;
    }

    .info-list-item > p {
        padding-left: 30px;
    }



    .layui-badge-list .layui-badge {
        margin-right: 6px;
    }

    .layui-badge-list .layui-badge {
        padding: 2px 7px;
        border: 1px solid #ccc;
        margin-bottom: 8px;
        background-color: #fafafa !important;
    }

    .bd-list-item {
        padding: 14px 0;
        border-bottom: 1px solid #e8e8e8;
        position: relative;
    }

    .bd-list-item .bd-list-item-img {
        width: 48px;
        height: 48px;
        line-height: 48px;
        margin-right: 12px;
        display: inline-block;
        vertical-align: middle;
    }

    .bd-list-item .bd-list-item-content {
        display: inline-block;
        vertical-align: middle;
    }

    .bd-list-item .bd-list-item-lable {
        margin-bottom: 4px;
        color: #333;
    }

    .bd-list-item .bd-list-item-oper {
        position: absolute;
        right: 0;
        top: 50%;
        text-decoration: none !important;
        transform: translateY(-50%);
    }

    .user-info-form .layui-form-item {
        margin-bottom: 25px;
    }
</style>
</html>
