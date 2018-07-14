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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ds-manager.css">
    <title>后台登录</title>
</head>
<body style="background-color: #f2f2f2;">
<div class="ds-manager-title">网站管理后台</div>
<div class="ds-manager-login-register">
    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief" style="box-shadow: 5px 5px 10px #c3c3c3;">
        <ul class="layui-tab-title" style="text-align: center;">
            <li class="layui-this" style="font-size: 20px;">登录</li>
            <li style="font-size: 20px;">注册</li>
        </ul>
        <div class="layui-tab-content">
            <%--start-管理员登录--%>
            <div class="layui-tab-item layui-show">
                <form class="layui-form" action="${pageContext.request.contextPath}/login" method="post">
                    <div class="layui-form-item" style="margin-top: 30px;">
                        <label class="layui-form-label" style="margin-left: 120px;">账号</label>
                        <div class="layui-input-block" style="margin-left: 230px;">
                            <input style="width: 60%;" type="text" name="username" lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label" style="margin-left: 120px;">密码</label>
                        <div class="layui-input-block" style="margin-left: 230px;">
                            <input style="width: 60%;" type="password" name="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <%--start-用户名或密码错误--%>
                    <div style="text-align: center;color: red;">
                        <%--${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}--%>

                        <c:if test="${param.error == 'true'}">
                            用户名或密码错误!
                        </c:if>
                    </div>
                    <%--start-用户名或密码错误--%>

                    <div class="layui-form-item" style="margin-top: 90px;text-align: center;">
                        <div class="layui-input-block" style="margin-left: 0;">
                            <button style="padding: 0 40px;" class="layui-btn" lay-submit="" lay-filter="demo1">登录</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
            <%--end-管理员登录--%>

            <%--start-管理员注册--%>
            <div class="layui-tab-item">
                <form class="layui-form" action="${pageContext.request.contextPath}/adminUser/adminRegister" method="post">

                    <div class="layui-form-item">
                        <label class="layui-form-label">账号</label>
                        <div class="layui-input-block">
                            <input style="width: 80%;" type="text" name="username" lay-verify="verifyUsername" placeholder="请输入账号" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">密码</label>
                        <div class="layui-input-block">
                            <input style="width: 80%;" id="pass" type="password" name="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">确认密码</label>
                        <div class="layui-input-block">
                            <input style="width: 80%;" type="password" lay-verify="repass" placeholder="确认密码" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">真实姓名</label>
                        <div class="layui-input-block">
                            <input style="width: 80%;" type="text" name="name" lay-verify="title" autocomplete="off" placeholder="请输入姓名" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-block">
                            <input type="radio" name="gender" value="男" title="男" checked="">
                            <input type="radio" name="gender" value="女" title="女">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">生日</label>
                            <div class="layui-input-inline">
                                <input name="birthday" type="text" class="layui-input" id="layui-birth" placeholder="yyyy-MM-dd">
                            </div>
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">邮箱</label>
                        <div class="layui-input-block">
                            <input style="width: 80%;" type="text" name="email" lay-verify="email" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">手机</label>
                        <div class="layui-input-block">
                            <input style="width: 80%;" type="tel" name="cellphone" lay-verify="required|phone" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
            <%--end-管理员注册--%>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.all.js"></script>

<script>

    //选择生日
    layui.use('laydate', function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit;
        var laydate = layui.laydate;

        //常规用法
        laydate.render({
            elem: '#layui-birth'
        });

        //自定义验证规则
        form.verify({
            pass: [/(.+){1,200}$/, '密码必须1到200位']
            ,
            repass: function(value) {
                //获取密码
                var pass = $("#pass").val();
                if(!new RegExp(pass).test(value)) {
                    return '两次输入的密码不一致';
                }
            },
            verifyUsername : function(value){
                var msg = '';
                $.ajax({
                    url: "${pageContext.request.contextPath}/adminUser/verifyUsername",
                    type: "post",
                    async: false,
                    data: {
                        username:value
                    },
                    dataType: "json",
                    success: function (data) {
                        msg = data.username;
                    }
                });
                if(msg == value){return "用户名已存在";}
            }
        });
    });
</script>
</html>