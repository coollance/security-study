package com.coolance.security.app;

import com.coolance.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.coolance.core.properties.SecurityConstants;
import com.coolance.core.properties.SecurityProperties;
import com.coolance.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    private SpringSocialConfigurer coolanceSocialSecurityConfigurer;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_AUTHENTICATION_URL)
                //自定义表单提交请求
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(coolanceAuthenticationSuccessHandler)
                .failureHandler(coolanceAuthenticationFailureHandler);
        http//.apply(validateCodeSecurityConfig)
            //    .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .apply(coolanceSocialSecurityConfigurer)
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
