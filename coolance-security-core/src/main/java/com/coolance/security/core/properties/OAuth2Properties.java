package com.coolance.security.core.properties;

import lombok.Data;

/**
 * @ClassName OAuth2Properties
 * @Description 认证服务器参数配置
 * @Author Coolance
 * @Version
 * @Date 2019/9/9 14:03
 */
@Data
public class OAuth2Properties {

    private OAuth2ClientProperties[] clients = {};

    /**
     * 使用jwt时为token签名的秘钥
     */
    private String jwtSigningKey = "coolance";

}
