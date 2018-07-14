<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>后台管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/framework/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/framework/build/css/app.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" media="all">
</head>

<body>
<div class="layui-layout layui-layout-admin kit-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">后台管理</div>
        <div class="layui-logo kit-logo-mobile">DS</div>
        <%--<ul class="layui-nav layui-layout-left kit-nav">
            <li class="layui-nav-item"><a href="javascript:;">xxx</a></li>
            <li class="layui-nav-item"><a href="javascript:;">xxx</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">xxx</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">邮件管理</a></dd>
                    <dd><a href="javascript:;">消息管理</a></dd>
                    <dd><a href="javascript:;">授权管理</a></dd>
                </dl>
            </li>
        </ul>--%>
        <ul class="layui-nav layui-layout-right kit-nav">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${pageContext.request.contextPath}/img/tuzi.png" class="layui-nav-img">
                    <span id="loginname"></span>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">基本资料</a></dd>
                    <dd><a href="javascript:;">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out" aria-hidden="true"></i> 退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black kit-side">
        <div class="layui-side-scroll">
            <div class="kit-side-fold"><i class="fa fa-navicon" aria-hidden="true"></i></div>
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->

            <ul class="layui-nav layui-nav-tree" lay-filter="kitNavbar" kit-navbar>

                

                <%--用户管理--%>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-user" aria-hidden="true"></i><span> 用户管理</span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" kit-target data-options="{url:'${pageContext.request.contextPath}/adminUser/adminUserManage',icon:'fa fa-edit',title:'个人信息',id:'7'}">
                                <i class="fa fa-edit"></i><span> 个人信息</span></a>
                        </dd>
                    </dl>
                </li>


                <%--表格表单--%>
                <%--<li class="layui-nav-item">
                    <a href="javascript:;" data-url="manager/framework/components/table/table.html" data-name="table" kit-loader><i class="fa fa-plug" aria-hidden="true"></i><span> 表格(page)</span></a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;" data-url="manager/framework/views/form.html" data-name="form" kit-loader><i class="fa fa-plug" aria-hidden="true"></i><span> 表单(page)</span></a>
                </li>--%>
            </ul>
        </div>
    </div>
    <div class="layui-body" id="container">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">主体内容加载中,请稍等...</div>
    </div>

    <%--<div class="layui-footer">
        <!-- 底部固定区域 -->
        &lt;%&ndash;2017 &copy;
        <a href="http://xxxxx.net/">xxxxxx.net</a> license&ndash;%&gt;
    </div>--%>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/manager/framework/plugins/layui/layui.js"></script>
<script>
    var message;
    layui.config({
        base: '${pageContext.request.contextPath}/manager/framework/build/js/'
    }).use(['app', 'message'], function() {
        var app = layui.app,
            $ = layui.jquery,
            layer = layui.layer;
        //将message设置为全局以便子页面调用
        message = layui.message;
        //主入口
        app.set({
            type: 'iframe'
        }).init();

    });

    $(function(){
        //获取登录的管理员用户名
        $.post("${pageContext.request.contextPath}/adminUser/loginAdminUser",function(data){
            $("#loginname").html(data.username);
        },"json");
    });
</script>
</body>

</html>