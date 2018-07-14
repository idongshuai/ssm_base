<%--author:董帅--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员用户</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
</head>
<body>
<section class="layui-DongShuai-box">
    <div class="DongShuai-personal">
        <div class="layui-tab">
            <blockquote class="layui-elem-quote admin_user_show">

            </blockquote>


            <!-- 管理员账号 -->
            <div class="layui-form personal-account_list">
                <table class="layui-table" style="word-break: break-all;">
                    <colgroup>
                       <%-- <col width="50">
                        <col>
                        <col>
                        <col>
                        <col width="9%">
                        <col width="9%">
                        <col width="13%">--%>
                    </colgroup>
                    <thead>
                    <tr>
                        <%--<th>
                            <input name="like[selAll]" lay-filter="allChoose" id="allChoose" type="checkbox"  title="全选">
                            <div class="layui-unselect layui-form-checkbox" lay-skin="primary">
                                <i class="layui-icon"></i>
                            </div>
                        </th>--%>
                        <th>用户账号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>生日</th>
                        <th>邮箱</th>
                        <th>手机</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody class="admin_user_content"></tbody>
                </table>

                <!--start-分页-->
                <div class="DongShuai-table-page clearfix" style="margin-left: 20px;">
                    <%--分页条--%>
                    <div id="page" class="page"></div>
                </div>
                <!--end-分页-->
            </div>
        </div>
    </div>

</section>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/admin-user-manage.js"></script>

</body>
<script>

    layui.use(['jquery','layer','element','laypage'],function(){
        window.jQuery = window.$ = layui.jquery;
        window.layer = layui.layer;
        var laypage = layui.laypage;

        // 添加用户
        $("body").on("click", ".addAdminUserBtn", function () {
            //弹出editProject.jsp页面
            layer.open({
                type: 2,
                title: '编辑用户信息',
                shadeClose: true,
                shade: 0.8,
                area: ['90%', '95%'],
                content: Path + '/manager/admin_user/addAdminUser.jsp'
            });

        });

        // 编辑用户
        $("body").on("click", ".admin_user_edit", function () {
            var $parent = $(this).parent().parent();

            console.log("id:" + $parent.find("#adminUserId").val());

            data = {
                id: $parent.find("#adminUserId").val(),
                originalName: $parent.find("#originalName").html(),
                originalGender: $parent.find("#originalGender").html(),
                originalBirthday: $parent.find("#originalBirthday").html(),
                originalEmail: $parent.find("#originalEmail").html(),
                originalCellphone: $parent.find("#originalCellphone").html()
            };

            //弹出editProject.jsp页面
            layer.open({
                type: 2,
                title: '编辑用户信息',
                shadeClose: true,
                shade: 0.8,
                area: ['90%', '95%'],
                content: Path + '/manager/admin_user/editAdminUser.jsp'
            });

        });

        //删除用户
        $("body").on("click",".admin_user_del",function(){
            var _this = $(this);
            layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
                var id = _this.parent().parent().find("#adminUserId").val();
                $.post(Path + "/adminUser/deleteAdminUserById",{id:id},function(data){
                    if(data == "delOK"){
                        _this.parents("tr").remove();
                        layer.close();
                        layer.msg("删除成功");
                        location.reload();
                    }
                },"text");
            });
        })

    });
</script>
</html>