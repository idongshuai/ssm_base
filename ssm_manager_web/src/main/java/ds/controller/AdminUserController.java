package ds.controller;

import ds.po.AdminUser;
import ds.po.JsonMessage;
import ds.service.AdminUserCustomService;
import ds.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 董帅
 */
@Controller
@RequestMapping("/adminUser")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private AdminUserCustomService adminUserCustomService;

    /**
     * 注册管理员用户
     *
     * @param adminUser
     * @return
     */
    @RequestMapping("/adminRegister")
    public String adminRegister(AdminUser adminUser) {

        //密码加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(adminUser.getPassword());
        adminUser.setPassword(encodePassword);

        adminUserService.saveAdminUser(adminUser);

        return "/adminLogin.jsp";
    }

    /**
     * 获取当前登录的用户, 返回到前端页面
     *
     * @return
     */
    @RequestMapping("/loginAdminUser")
    @ResponseBody
    public AdminUser loginAdminUser(HttpServletRequest request) {
//        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        // 经过spring security认证后，security会把一个SecurityContextImpl对象存储到session中，
        // 此对象中有当前用户的各种资料
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
                .getSession().getAttribute("SPRING_SECURITY_CONTEXT");

        String name = securityContextImpl.getAuthentication().getName();

        AdminUser adminUser = adminUserCustomService.getAdminUserByUsername(name);
        return adminUser;
    }

    /**
     * 验证用户名是否存在
     *
     * @return
     */
    @RequestMapping("/verifyUsername")
    @ResponseBody
    public AdminUser verifyUsername(String username) {
        return adminUserCustomService.getAdminUserByUsername(username);
    }

    /**
     * 跳转到登录页
     */
    @RequestMapping("/jumpToLogin")
    public String jumpToLogin() {
        return "/adminLogin.jsp";
    }

    /**
     * 跳转到管理员用户的管理页面
     * @return
     */
    @RequestMapping("adminUserManage")
    public String adminUserManage() {
        return "/manager/admin_user/admin_user_manage.jsp";
    }

    /**
     * 根据用户名查询此用户可管理的所有用户
     * @param loginAdminUsername
     * @return
     */
    @RequestMapping("getAdminUserByUsername")
    @ResponseBody
    public List<AdminUser> getAdminUserByUsername(String loginAdminUsername) {

        List<AdminUser> adminUsersList = adminUserCustomService.getAdminUsersByLoginAdminUsername(loginAdminUsername);

        return adminUsersList;
    }

    /**
     * 添加管理员用户
     * @param adminUser
     * @return
     */
    @RequestMapping("saveAdminUser")
    @ResponseBody
    public JsonMessage saveAdminUser(AdminUser adminUser) {
        if (adminUser.getPassword() != null && !"".equals(adminUser.getPassword().trim())) {
            //密码加密
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodePassword = passwordEncoder.encode(adminUser.getPassword());
            adminUser.setPassword(encodePassword);
        }

        adminUserService.saveAdminUser(adminUser);
        JsonMessage jsonMessage = new JsonMessage();
        jsonMessage.setMsg("saveOK");
        return jsonMessage;
    }

    /**
     * 根据id修改用户信息
     * @param adminUser
     */
    @RequestMapping("editAdminUser")
    @ResponseBody
    public JsonMessage editAdminUser(AdminUser adminUser) {

        if (adminUser.getPassword() != null && !"".equals(adminUser.getPassword().trim())) {
            //密码加密
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodePassword = passwordEncoder.encode(adminUser.getPassword());
            adminUser.setPassword(encodePassword);
        }

        adminUserCustomService.editAdminUser(adminUser);

        JsonMessage jsonMessage = new JsonMessage();
        jsonMessage.setMsg("editOK");
        return jsonMessage;
    }

    /**
     * 根据id删除管理员用户
     * @param id
     */
    @RequestMapping("deleteAdminUserById")
    public void deleteAdminUserById(int id, HttpServletResponse response) throws IOException {
        adminUserCustomService.deleteAdminUserById(id);

        response.getWriter().print("delOK");
    }
}
