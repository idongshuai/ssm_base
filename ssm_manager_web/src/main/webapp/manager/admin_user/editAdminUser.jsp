<%--author:董帅--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑管理员用户</title>
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
    <input type="hidden" name="id">
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input style="width: 80%;" type="password" name="password" placeholder="如果不修改则不用输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">确认密码</label>
        <div class="layui-input-block">
            <input style="width: 80%;" type="password" placeholder="如果不修改则不用输入" autocomplete="off" class="layui-input">
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
            <input type="radio" name="gender" value="男" title="男">
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
    });
</script>

<script>
    $(function(){

        $("input[name='id']").val(parent.data.id);
        $("input[name='name']").val(parent.data.originalName);
        // $("input[name='gender']").val(parent.data.originalGender);

        console.log(parent.data.originalGender);

        if('男' == parent.data.originalGender) {
            $('input[title="男"]').attr("checked","true");
        }else{
            $('input[title="女"]').attr("checked","true");
        }

        $("input[name='birthday']").val(parent.data.originalBirthday);
        $("input[name='email']").val(parent.data.originalEmail);
        $("input[name='cellphone']").val(parent.data.originalCellphone);
    });


    // 编辑, ajax方式提交表单
    $("#immediatelySubmit").on("click", function(){
            $("#mainForm").ajaxSubmit({
                url: '${pageContext.request.contextPath}/adminUser/editAdminUser',
                type: 'post',
                dataType: 'json',

                beforeSubmit: function () {},
                success: function (data) {
                    // console.log("返回值" + data.msg);
                    if (data.msg == "editOK") {
                        //当在iframe页面关闭自身时，在iframe页执行以下js脚本
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                        top.layer.msg("用户信息编辑成功！",{time:1000});
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