package com.coolance.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName MyConstraint
 * @Description 自定义校验注解
 * @Author Coolance
 * @Version
 * @Date 2019/8/17 17:52
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {
    String message() default "这是一条测试自定校验注解";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
