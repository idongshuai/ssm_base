<%--author:董帅--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="robots" content="noindex,nofollow">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui-admin.css">
    <title>error</title>
</head>
<body>

<div class="layadmin-tips">
    <i class="layui-icon" face=""></i>

    <%--500--%>
    <div class="layui-text" style="font-size: 20px;">
        好像出错了呢! (${message})
    </div>

    <%--404--%>
    <%--<div class="layui-text">
        <h1>
            <span class="layui-anim layui-anim-loop layui-anim-">4</span>
            <span class="layui-anim layui-anim-loop layui-anim-rotate">0</span>
            <span class="layui-anim layui-anim-loop layui-anim-">4</span>
        </h1>
    </div>--%>

</div>


</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>

<script type="text/javascript">
    $(function(){

        /*$.post("/DsWebServlet",{method:"findAllProjects"},
            function(data){
                $.each(data,function(i,obj){
                    console.log(i + "---" + obj);
                });
            },
            "json");*/

        /*$.ajax({
        url: '/adminUser/loginAdminUser',
        type: 'post',
        dataType: 'json',
        success: function(data) {
        console.log(data.username);
        }
        });*/
    });
</script>
</html>