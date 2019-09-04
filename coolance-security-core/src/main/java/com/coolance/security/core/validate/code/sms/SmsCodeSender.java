package com.coolance.security.core.validate.code.sms;

/**
 * @ClassName SmsCodeSender
 * @Description 发送短信接口
 * @Author Coolance
 * @Version
 * @Date 2019/8/27 21:14
 */
public interface SmsCodeSender {
    /**
     * 发送短信
     *
     * @param mobile
     * @param code
     */
    void send(String mobile, String code);
}
