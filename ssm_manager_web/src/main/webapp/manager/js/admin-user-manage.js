//获取项目根路径
var curWwwPath = window.document.location.href;
var pathName =  window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
var localhostPaht = curWwwPath.substring(0,pos);
var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
var Path=localhostPaht + projectName;

var loginAdminUsername;

$(function(){
    //获取登录的管理员用户名
    $.post(Path + "/adminUser/loginAdminUser",function(data){
        loginAdminUsername = data.username;

        if ("admin" == data.username) {

            var adminShow = '<div class="layui-inline">\n' +
                '                    <a class="layui-btn layui-btn-normal addAdminUserBtn">添加管理员账号</a>\n' +
                '                </div>';

            $(".admin_user_show").append(adminShow);
        }


        $.post(Path + "/adminUser/getAdminUserByUsername",
            {loginAdminUsername:loginAdminUsername},
            function(data){
                $(".admin_user_content").html("");

                $.each(data, function(i, obj){

                    var tr = '<tr>\n' +
                        '<input type="hidden" id="adminUserId" value="'+obj.id+'">' +
                        '<td>'+obj.username+'</td>\n' +
                        '<td id="originalName">'+obj.name+'</td>\n' +
                        '<td id="originalGender">'+obj.gender+'</td>\n' +
                        '<td id="originalBirthday">'+obj.birthday+'</td>\n' +
                        '<td id="originalEmail">'+obj.email+'</td>\n' +
                        '<td id="originalCellphone">'+obj.cellphone+'</td>\n' +
                        '<td>\n' +
                        '   <a class="layui-btn layui-btn-sm admin_user_edit"><i class="layui-icon layui-icon-edit"></i></a>\n' +
                        '   <a class="layui-btn layui-btn-danger layui-btn-sm admin_user_del" data-id="2"><i class="layui-icon"></i></a>\n' +
                        '</td>\n' +
                        '</tr>';

                    $(".admin_user_content").append(tr);
                });
            },"json");
    },"json");
});