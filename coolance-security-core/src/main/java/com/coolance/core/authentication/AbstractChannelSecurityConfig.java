package com.coolance.core.authentication;

import com.coolance.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @ClassName AbstractChannelSecurityConfig
 * @Description 抽象共有配置类
 * @Author Coolance
 * @Version
 * @Date 2019/8/28 20:38
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    protected AuthenticationSuccessHandler coolanceAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler coolanceAuthenticationFailureHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_AUTHENTICATION_URL)
                //自定义表单提交请求
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(coolanceAuthenticationSuccessHandler)
                .failureHandler(coolanceAuthenticationFailureHandler);
    }
}
