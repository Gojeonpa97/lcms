<%@ include file="/WEB-INF/views/base/sys_tag.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>角色管理框</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${staticPath}/common/layui/css/layui.css" media="all">
</head>
<body>


<div class="layui-form" lay-filter="layuiadmin-form-role" id="layuiadmin-form-role" style="padding: 20px 30px 0 0;">
    <div class="layui-form-item">
        <label class="layui-form-label">角色名称</label>
        <div class="layui-input-inline">
            <input type="text" id = "rolename" name="name" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">显示顺序</label>
        <div class="layui-input-inline">
            <input type="text" id = "sort" name="sort" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">描述</label>
        <div class="layui-input-inline">
            <input type="text" id = "description" name="description" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div id="dept_tree">
    </div>
    <div class="layui-form-item layui-hide">
        <button class="layui-btn" lay-submit lay-filter="LAY-user-role-submit" id="LAY-user-role-submit">提交</button>
    </div>
</div>
<script src="${staticPath}/common/layui/layui.js"></script>
<script>
    layui.config({
        base: '${staticPath}/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form','tree'], function(){

        var $ = layui.$
            ,form = layui.form
            ,admin = layui.admin
            ,tree = layui.tree
        //模拟数据1
    ,data1 = [{
            title: '江西'
            ,id: 1
            ,children: [{
                title: '南昌'
                ,id: 1000
                ,children: [{
                    title: '青山湖区'
                    ,id: 10001
                },{
                    title: '高新区'
                    ,id: 10002
                }]
            },{
                title: '九江'
                ,id: 1001
            },{
                title: '赣州'
                ,id: 1002
            }]
        },{
            title: '广西'
            ,id: 2
            ,children: [{
                title: '南宁'
                ,id: 2000
            },{
                title: '桂林'
                ,id: 2001
            }]
        },{
            title: '陕西'
            ,id: 3
            ,children: [{
                title: '西安'
                ,id: 3000
            },{
                title: '延安'
                ,id: 3001
            }]
        }];
        var sid = admin.getParamByUrl('sid')
        $.ajax({
            type :'get'
            ,url:'/v1/system/role/queryRoleBySid'
            ,data:{
                sid :sid
            }
            ,success:function (res) {

                $('#rolename').val(res.data.name);
                $('#sort').val(res.data.sort);
                $('#description').val(res.data.description);

            }

        });

        tree.render({
            elem: '#dept_tree' //传入元素选择器
            ,showCheckbox: true  //是否显示复选框
            ,data:data1
        });
    })
</script>
</body>
</html>