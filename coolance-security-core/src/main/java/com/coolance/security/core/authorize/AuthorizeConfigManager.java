package com.coolance.security.core.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @ClassName AuthorizeConfigManager
 * @Description 权限配置管理器
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 9:32
 */
public interface AuthorizeConfigManager {
    /**
     * 权限配置
     * @param config
     */
    void configure(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);
}
