package ds.service.impl;

import ds.mapper.AdminUserMapper;
import ds.po.AdminUser;
import ds.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员用户service层实现类
 * @author 董帅
 */
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    /**
     * 根据id查询管理员用户
     * @param id
     * @return
     */
    @Override
    public AdminUser getAdminUserById(Integer id) {
        return adminUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 注册管理员用户
     * @param adminUser
     */
    @Override
    public void saveAdminUser(AdminUser adminUser) {
        adminUserMapper.insertSelective(adminUser);
    }
}
