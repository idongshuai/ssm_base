<%--author:董帅--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加管理员用户</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">

</head>
<body>
<form class="layui-form" method="post" id="mainForm">
    <div class="layui-form-item">
        <label class="layui-form-label">账号</label>
        <div class="layui-input-block">
            <input style="width: 80%;" type="password" name="username"  lay-verify="verifyUsername" placeholder="请输入账号" autocomplete="off" class="layui-input">
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
            <input style="width: 80%;" type="text" name="name" autocomplete="off" placeholder="请输入姓名" class="layui-input">
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
            <input style="width: 80%;" type="text" name="email" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">手机</label>
        <div class="layui-input-block">
            <input style="width: 80%;" type="tel" name="cellphone" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <input id="immediatelySubmit" class="layui-btn" lay-submit="" lay-filter="demo1" value="提交修改"/>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/newsadd.js"></script>--%>
<script>

    layui.use(['laydate','form', 'layedit'], function() {
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
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

<script>

    // 添加管理员用户, ajax方式提交表单
    $("#immediatelySubmit").on("click", function(){
        $("#mainForm").ajaxSubmit({
            url: '${pageContext.request.contextPath}/adminUser/saveAdminUser',
            type: 'post',
            dataType: 'json',

            beforeSubmit: function () {},
            success: function (data) {
                // console.log("返回值" + data.msg);
                if (data.msg == "saveOK") {
                    //当在iframe页面关闭自身时，在iframe页执行以下js脚本
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index); //再执行关闭
                    top.layer.msg("添加管理员成功！",{time:1000});
                    //刷新父页面
                    parent.location.reload();

                } else {
                    top.layer.msg("error！",{time:500});
                }
            },
            error:function(){
                top.layer.msg("error！",{time:500});
                var index2 = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index2);
                parent.location.reload();
            }
        });
    });
</script>
</body>
</html>