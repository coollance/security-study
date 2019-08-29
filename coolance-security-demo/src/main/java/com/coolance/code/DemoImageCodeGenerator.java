package com.coolance.code;

import com.coolance.core.validate.code.image.ImageCode;
import com.coolance.core.validate.code.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName DemoImageCodeGenerator
 * @Description 自定义验证码生成器
 * @Author Coolance
 * @Version
 * @Date 2019/8/22 22:24
 */
//@Component(value = "imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("DemoImageCodeGenerator:更高级的验证码生成器");
        return null;
    }
}
