package com.coolance.validator;

import com.coolance.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName MyConstraintValidator
 * @Description 自定义校验逻辑
 * @Author Coolance
 * @Version
 * @Date 2019/8/17 17:56
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Autowired
    HelloService helloService;


    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("MyConstraintValidator initialize");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println("校验的数据：" + value);
        String coolance = helloService.greeting("coolance");
        System.out.println("helloService:" + coolance);
        return false;
    }
}
