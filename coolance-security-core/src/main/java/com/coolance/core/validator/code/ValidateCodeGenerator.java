package com.coolance.core.validator.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName ValidateCodeGenerator
 * @Description 验证码生成器接口
 * @Author Coolance
 * @Version
 * @Date 2019/8/22 22:16
 */
public interface ValidateCodeGenerator {
    /**
     * 验证码生成方法
     * @param request
     * @return
     */
    ImageCode createImageCode(ServletWebRequest request);
}
