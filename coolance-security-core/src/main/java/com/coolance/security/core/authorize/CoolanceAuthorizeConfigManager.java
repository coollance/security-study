package com.coolance.security.core.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @ClassName CoolanceAuthorizeConfigManager
 * @Description 权限配置管理器
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 9:33
 */
@Component
public class CoolanceAuthorizeConfigManager implements AuthorizeConfigManager {

    @Autowired
    private List<AuthorizeConfigProvider> authorizeConfigProviders;

    @Override
    public void configure(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        for (AuthorizeConfigProvider provider : authorizeConfigProviders) {
            provider.configure(config);
        }
    }
}
