package com.coolance.security.app;

/**
 * @ClassName AppSecretException
 * @Description 自定义异常
 * @Author Coolance
 * @Version
 * @Date 2019/9/7 14:35
 */
public class AppSecretException extends RuntimeException {

    public AppSecretException(String message) {
        super(message);
    }
}
