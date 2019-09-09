/**
 *
 */
package com.coolance.security.server;

import com.coolance.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @ClassName TokenStoreConfig
 * @Description token存储配置
 * @Author Coolance
 * @Version
 * @Date 2019/9/9 14:41
 */
@Configuration
public class TokenStoreConfig {

    /**
     * 使用redis存储token的配置，只有在coolance.security.oauth2.tokenStore配置为redis时生效
     */
    @Configuration
    @ConditionalOnProperty(prefix = "coolance.security.oauth2", name = "tokenStore", havingValue = "redis")
    public static class RedisTokenStoreConfig {
        @Autowired
        private RedisConnectionFactory redisConnectionFactory;

        @Bean
        public TokenStore redisTokenStore() {
            return new RedisTokenStore(redisConnectionFactory);
        }
    }

    @Configuration
    @ConditionalOnProperty(prefix = "coolance.security.oauth2", name = "tokenStore", havingValue = "jwt", matchIfMissing = true)
    public static class JwtTokenStoreConfig {

        @Autowired
        private SecurityProperties securityProperties;

        @Bean
        public TokenStore jwtTokenStore() {
            JwtTokenStore jwtTokenStore = new JwtTokenStore(jwtAccessTokenConverter());
            return jwtTokenStore;
        }

        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter() {
            JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
            tokenConverter.setSigningKey(securityProperties.getOauth2().getJwtSigningKey());
            return tokenConverter;
        }

        @Bean
        @ConditionalOnMissingBean(name = "jwtTokenEnhancer")
        public TokenEnhancer jwtTokenEnhancer() {
            return new JwtTokenEnhancer();
        }

    }

}
