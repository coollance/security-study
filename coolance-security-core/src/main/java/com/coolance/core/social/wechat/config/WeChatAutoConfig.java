package com.coolance.core.social.wechat.config;

import com.coolance.core.properties.SecurityProperties;
import com.coolance.core.properties.WeChatProperties;
import com.coolance.core.social.CoolanceConnectView;
import com.coolance.core.social.qq.connet.QQConnectionFactory;
import com.coolance.core.social.wechat.connet.WeChatConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.web.servlet.View;

import javax.sql.DataSource;

/**
 * @ClassName WeChatAutoConfig
 * @Description 微信登录配置类
 * @Author Coolance
 * @Version
 * @Date 2019/9/2 09:34
 */
@Configuration
@ConditionalOnProperty(prefix = "coolance.security.social.weChat", name = "appId")
public class WeChatAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private ConnectionSignUp connectionSignUp;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        WeChatProperties weChatConfig = securityProperties.getSocial().getWeChat();
        return new WeChatConnectionFactory(weChatConfig.getProviderId(), weChatConfig.getAppId(), weChatConfig.getAppSecret());
    }

    /**
     * 如果写在SocialConfig中SocialAuthenticationProvider的usersConnectionRepository
     * 会使用默认的InMemoryUsersConnectionRepository
     *
     * @param connectionFactoryLocator
     * @return
     */
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository =
                new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        //设置表前缀 userconnection
        repository.setTablePrefix("coolance_");
        //设置自动注册
        if (connectionSignUp != null) {
            repository.setConnectionSignUp(connectionSignUp);
        }
        return repository;
    }

    @Bean({"connect/weixinConnected", "connect/weixinConnect"})
    @ConditionalOnMissingBean(name = "weixinConnectView")
    public View coolanceConnectView() {
        return new CoolanceConnectView();
    }

}
