package com.coolance.security.core.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @ClassName AuthorizeConfigProvider
 * @Description 权限配置提供器
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 9:10
 */
public interface AuthorizeConfigProvider {
    /**
     * 权限配置
     * @param config
     */
    void configure(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);
}
