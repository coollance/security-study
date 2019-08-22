package com.coolance.code;

import com.coolance.core.validator.code.ImageCode;
import com.coolance.core.validator.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName DemoImageCodeGenerator
 * @Description 自定义验证码生成器
 * @Author Coolance
 * @Version
 * @Date 2019/8/22 22:24
 */
@Component(value = "imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode createImageCode(ServletWebRequest request) {
        System.out.println("DemoImageCodeGenerator:更高级的验证码生成器");
        return null;
    }
}
