## 项目介绍:

基础的SSM框架的使用, 用户的CRUD, maven管理项目

后端技术: sprig5.0.2, spring mvc5.0.2, spring security5.0.2, mybatis, druid
前端技术: layui
数据库: MySQL5.6
tomcat: 8.5



## 项目框架

1. ssm_parent : 项目父工程, 管理jar包

2. ssm_common : pojo和utils, 继承父工程

3. ssm_dao : 项目dao层, 继承ssm_common

4. ssm_service : 项目service层, 继承ssm_dao

5. ssm_manager_web : 管理后台的web层, 继承ssm_service

    

## 前端目录

css : 全局css
font-awesome-4.7.0 : 页面图标字体
img : 图片
js : 全局js
layui : 全局layui插件
layuires : layui的开源轻博客的插件
manager : 管理后台的所有页面
	admin_user : 管理用户的页面
	common : 管理后台的页面的公共资源
	css : 管理后台页面的css
	framework : 管理后台的框架首页及资源
	js : 管理后台的js
403.jsp
404.jsp
adminLogin.jsp
error.jsp
robotx.txt
template.jsp

## 数据库

ssm_db
	admin_user.sql