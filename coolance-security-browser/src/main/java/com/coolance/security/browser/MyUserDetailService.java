package com.coolance.security.browser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName com.coolance.security.browser.MyUserDetailService
 * @Description 处理用户信息获取逻辑
 * @Author Coolance
 * @Version
 * @Date 2019/8/19 16:48
 */
@Slf4j
@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户登录：" + username);
        String password = passwordEncoder.encode("123456");
        log.info("password:" + password);
        return new User(username, password,true, true,true,
                true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
