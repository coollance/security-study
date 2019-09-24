/**
 *
 */
package com.coolance.security.rbac.authorize;

import com.coolance.security.core.authorize.AuthorizeConfigProvider;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @ClassName RbacAuthorizeConfigProvider
 * @Description 权限配置提供器
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
@Component
@Order(Integer.MAX_VALUE)
public class RbacAuthorizeConfigProvider implements AuthorizeConfigProvider {

    /**
     * (non-Javadoc)
     *
     * @see com.coolance.security.core.authorize.AuthorizeConfigProvider
     * #config(org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry)
     */
    @Override
    public void configure(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.antMatchers(HttpMethod.GET, "/fonts/**").permitAll()
                .antMatchers(HttpMethod.GET, "/**/*.html", "/admin/me", "/resource").authenticated()
                .anyRequest().access("@rbacService.hasPermission(request, authentication)");
    }

}
