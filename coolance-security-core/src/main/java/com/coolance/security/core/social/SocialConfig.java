package com.coolance.security.core.social;

import com.coolance.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @ClassName SocialConfig
 * @Description 社交配置类 @EnableSocial:启动Spring Social的相应一些特性
 * @Author Coolance
 * @Version
 * @Date 2019/8/29 14:35
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 将SocialAuthenticationFilter配置到Spring Security过滤器链上的配置类
     * @return
     */
    //@Bean
    public SpringSocialConfigurer coolanceSocialSecurityConfigurer() {
        SpringSocialConfigurer socialConfigurer = new SpringSocialConfigurer();
        //设置注册页面路径，默认为/signUp
        socialConfigurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
        return socialConfigurer;
    }

    /**
     *
     * @return
     */
    @Bean
    public SpringSocialConfigurer coolanceSpringSocialConfigurer() {
        SpringSocialConfigurer socialConfigurer = new CoolanceSpringSocialConfigurer(securityProperties.getSocial().getFilterProcessesUrl());
        socialConfigurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
        return socialConfigurer;
    }

    /**
     * 工具类
     * 1、在注册在过程中如何拿到Spring Social的信息
     * 2、注册完成如何把业务的userId返回给Spring Social
     * @param connectionFactoryLocator
     * @return
     */
    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator,
                                                   UsersConnectionRepository usersConnectionRepository) {
        return new ProviderSignInUtils(connectionFactoryLocator, usersConnectionRepository);
    }

}
