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
    <title>模板页</title>
</head>
<body>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    $(function(){

        /*$.post("/adminUser",{method:"findAll"},
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