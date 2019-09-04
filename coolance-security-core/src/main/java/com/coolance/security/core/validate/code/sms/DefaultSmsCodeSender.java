package com.coolance.security.core.validate.code.sms;

/**
 * @ClassName DefaultSmsCodeSender
 * @Description 默认发送短信验证码的实现类
 * @Author Coolance
 * @Version
 * @Date 2019/8/27 21:17
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机号：" + mobile + "发送短信验证码：" + code);
    }

}
