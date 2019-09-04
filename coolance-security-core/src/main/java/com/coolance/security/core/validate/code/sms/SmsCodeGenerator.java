package com.coolance.security.core.validate.code.sms;

import com.coolance.security.core.properties.SecurityProperties;
import com.coolance.security.core.validate.code.ValidateCode;
import com.coolance.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName SmsCodeGenerator
 * @Description 短信验证码生成器
 * @Author Coolance
 * @Version
 * @Date 2019/8/27 21:10
 */
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        ValidateCode validateCode = new ValidateCode(code, securityProperties.getCode().getSms().getExpiredIn());
        return validateCode;
    }
}
