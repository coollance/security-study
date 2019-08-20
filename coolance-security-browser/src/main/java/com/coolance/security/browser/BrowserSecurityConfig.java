package com.coolance.security.browser;


import com.coolance.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName BrowserSecurityConfig
 * @Description 浏览器访问安全配置类
 * @Author Coolance
 * @Version
 * @Date 2019/8/19 12:48
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //使用默认方式登录
        //http.httpBasic();
        //使用表单登录
        http.formLogin()
                //自定义登录页面
                .loginPage("/authentication/require")
                //自定义表单提交请求
                .loginProcessingUrl("/authentication/form")
                .and()
                //授权相关配置
                .authorizeRequests()
                //设置白名单
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage()).permitAll()
                //任何请求
                .anyRequest()
                //都需要认证
                .authenticated()
                .and()
                //跨域请求伪造
                .csrf().disable();
    }
}
