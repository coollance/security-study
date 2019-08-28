package com.coolance.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName ValidateCodeProcessor
 * @Description 校验码处理器，封装不同校验码的处理逻辑
 * @Author Coolance
 * @Version
 * @Date 2019/8/27 21:44
 */
public interface ValidateCodeProcessor {
    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     *
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;
}
