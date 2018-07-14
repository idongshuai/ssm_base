package ds.service.impl;

import ds.mapper.AdminUserMapperCustom;
import ds.po.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 董帅
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private AdminUserMapperCustom adminUserMapperCustom;

    /**
     * 管理员登录,校验用户名密码
     * @param username
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            //根据用户名从数据库中查出用户
            AdminUser adminUser = adminUserMapperCustom.getAdminUserByUsername(username);

            List<GrantedAuthority> grantAuths = new ArrayList<>();

            grantAuths.add(new SimpleGrantedAuthority(adminUser.getRoles()));

            if (adminUser.getStatus().equals("1")) {
                return new User(username, adminUser.getPassword(), grantAuths);
            } else {
                return null;
            }
    }
}
