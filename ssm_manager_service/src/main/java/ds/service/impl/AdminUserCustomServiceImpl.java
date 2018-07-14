package ds.service.impl;

import ds.mapper.AdminUserMapperCustom;
import ds.po.AdminUser;
import ds.service.AdminUserCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 董帅
 */
@Service("adminUserCustomService")
public class AdminUserCustomServiceImpl implements AdminUserCustomService {

    @Autowired
    private AdminUserMapperCustom adminUserMapperCustom;

    /**
     * 根据username查询用户
     * @param username
     * @return
     */
    @Override
    public AdminUser getAdminUserByUsername(String username) {
        return adminUserMapperCustom.getAdminUserByUsername(username);
    }

    /**
     * 根据用户名查询此用户可管理的所有用户
     * @param loginAdminUsername
     * @return
     */
    @Override
    public List<AdminUser> getAdminUsersByLoginAdminUsername(String loginAdminUsername) {

        AdminUser adminUser = adminUserMapperCustom.getAdminUserByUsername(loginAdminUsername);

        //如果是管理员, 则获取所有用户信息
        if ("ROLE_ADMIN".equals(adminUser.getRoles())) {
            return adminUserMapperCustom.getAllAdminUsers();
        } else {
            //如果不是管理员, 则获取自己的信息
            AdminUser singleAdminUser = adminUserMapperCustom.getAdminUserByUsername(loginAdminUsername);
            List<AdminUser> adminUserList = new ArrayList<>();
            adminUserList.add(singleAdminUser);
            return adminUserList;
        }
    }

    /**
     * 根据id修改用户信息
     * @param adminUser
     */
    @Override
    public void editAdminUser(AdminUser adminUser) {
        adminUserMapperCustom.editAdminUser(adminUser);
    }

    /**
     * 根据id删除管理员用户
     * @param id
     */
    @Override
    public void deleteAdminUserById(int id) {
        adminUserMapperCustom.deleteAdminUserById(id);
    }
}
