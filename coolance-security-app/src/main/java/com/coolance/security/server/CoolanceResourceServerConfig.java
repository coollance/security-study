package com.coolance.security.server;

import com.coolance.security.app.authentication.openid.OpenIdAuthenticationSecurityConfig;
import com.coolance.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.coolance.security.core.properties.SecurityConstants;
import com.coolance.security.core.properties.SecurityProperties;
import com.coolance.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @ClassName CoolanceResourceServerConfig
 * @Description 资源服务器
 * @Author Coolance
 * @Version
 * @Date 2019/9/3 16:43
 */
@Configuration
@EnableResourceServer
public class CoolanceResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private AuthenticationFailureHandler coolanceAuthenticationFailureHandler;

    @Autowired
    private AuthenticationSuccessHandler coolanceAuthenticationSuccessHandler;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SpringSocialConfigurer coolanceSocialSecurityConfigurer;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_AUTHENTICATION_URL)
                //自定义表单提交请求
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(coolanceAuthenticationSuccessHandler)
                .failureHandler(coolanceAuthenticationFailureHandler);
        http.apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .apply(coolanceSocialSecurityConfigurer)
                .and()
                .apply(openIdAuthenticationSecurityConfig)
                .and()
                //授权相关配置
                .authorizeRequests()
                //设置白名单
                .antMatchers(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        SecurityConstants.DEFAULT_AUTHENTICATION_URL,
                        securityProperties.getBrowser().getLoginPage(),
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "*",
                        securityProperties.getBrowser().getSignUpUrl(),
                        securityProperties.getBrowser().getSession().getSessionInvalidUrl(),
                        securityProperties.getBrowser().getSignOutUrl(),
                        "/user/register").permitAll()
                //任何请求
                .anyRequest()
                //都需要认证
                .authenticated()
                .and()
                //跨域请求伪造
                .csrf().disable();
    }
}
