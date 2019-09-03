package com.coolance.core.properties;

import lombok.Data;

/**
 * @ClassName BrowserProperties
 * @Description 浏览器配置类
 * @Author Coolance
 * @Version
 * @Date 2019/8/20 10:31
 */
@Data
public class BrowserProperties {

    private SessionProperties session = new SessionProperties();

    private String loginPage = "/coolance-signIn.html";

    private LoginResponseType loginResponseType = LoginResponseType.JSON;

    private int rememberMeSeconds = 3600;

    private String signUpUrl = "/coolance-signUp.html";

    private String signOutUrl;
}
