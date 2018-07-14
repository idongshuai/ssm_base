package ds.service;

import ds.po.AdminUser;

import java.util.List;

/**
 * @author 董帅
 */
public interface AdminUserCustomService {

    /**
     * 根据username查询用户
     * @param username
     * @return
     */
    AdminUser getAdminUserByUsername(String username);

    /**
     * 根据用户名查询此用户可管理的所有用户
     * @param loginAdminUsername
     * @return
     */
    List<AdminUser> getAdminUsersByLoginAdminUsername(String loginAdminUsername);

    /**
     * 根据id修改用户信息
     * @param adminUser
     */
    void editAdminUser(AdminUser adminUser);

    /**
     * 根据id删除管理员用户
     * @param id
     */
    void deleteAdminUserById(int id);
}
