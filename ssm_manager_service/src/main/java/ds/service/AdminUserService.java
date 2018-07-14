package ds.service;

import ds.po.AdminUser;

/**
 * 管理员用户service层接口
 * @author 董帅
 */
public interface AdminUserService {

    /**
     * 根据id查询管理员用户
     * @param id
     * @return
     */
    AdminUser getAdminUserById(Integer id);

    /**
     * 注册管理员用户
     * @param adminUser
     */
    void saveAdminUser(AdminUser adminUser);
}
