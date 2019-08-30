package com.coolance.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @ClassName DemoConnectionSignUp
 * @Description 根据社交自动注册用户类
 * @Author Coolance
 * @Version
 * @Date 2019/8/30 14:13
 */
@Component
public class DemoConnectionSignUp implements ConnectionSignUp {

    @Override
    public String execute(Connection<?> connection) {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
