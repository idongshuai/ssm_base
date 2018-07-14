package ds.mapper;

import ds.po.AdminUser;

import java.util.List;

/**
 * 管理员用户,自定义mapper接口
 */
public interface AdminUserMapperCustom {

    /**
     * 根据username查询用户
     * @param username
     * @return
     */
    AdminUser getAdminUserByUsername(String username);

    /**
     * 获取所有用户信息
     * @return
     */
    List<AdminUser> getAllAdminUsers();

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