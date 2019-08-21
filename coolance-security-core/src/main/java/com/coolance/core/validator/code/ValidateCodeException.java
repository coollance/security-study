package com.coolance.core.validator.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @ClassName ValidateCodeException
 * @Description 验证码校验异常类
 * @Author Coolance
 * @Version
 * @Date 2019/8/21 9:20
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
