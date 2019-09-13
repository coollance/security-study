package com.coolance.security;

import com.coolance.security.core.authorize.AuthorizeConfigProvider;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @ClassName DemoAuthorizeConfigProvider
 * @Description 用户模块权限配置提供器
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 9:40
 */
@Component
public class DemoAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Override
    public void configure(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.antMatchers(HttpMethod.GET, "/demo.html").hasRole("admin");
    }
}
