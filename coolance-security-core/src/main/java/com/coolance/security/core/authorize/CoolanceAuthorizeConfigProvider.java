package com.coolance.security.core.authorize;

import com.coolance.security.core.properties.SecurityConstants;
import com.coolance.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @ClassName CoolanceAuthorizeConfigProvider
 * @Description 权限模块权限配置提供器
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 9:27
 */
@Component
public class CoolanceAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void configure(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.antMatchers(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                SecurityConstants.DEFAULT_AUTHENTICATION_URL,
                securityProperties.getBrowser().getLoginPage(),
                SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "*",
                securityProperties.getBrowser().getSignUpUrl(),
                securityProperties.getBrowser().getSession().getSessionInvalidUrl(),
                securityProperties.getBrowser().getSignOutUrl()).permitAll();
    }
}
