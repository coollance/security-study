package com.coolance.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @ClassName TimeAspect
 * @Description 切片类
 * @Author Coolance
 * @Version
 * @Date 2019/8/18 6:54
 */
@Aspect
@Component
public class TimeAspect {
    @Around("execution(* com.coolance.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("TimeAspect handleControllerMethod start");
        Object[] args = pjp.getArgs();
        for(Object arg : args) {
            System.out.println("arg is " + arg);
        }
        long start = System.currentTimeMillis();
        Object object = pjp.proceed();
        System.out.println("TimeAspect 耗时：" + (System.currentTimeMillis() - start));
        System.out.println("TimeAspect handleControllerMethod end");
        return object;
    }
}
