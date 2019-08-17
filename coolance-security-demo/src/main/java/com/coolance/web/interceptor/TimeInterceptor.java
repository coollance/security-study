package com.coolance.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName TimeInterceptor
 * @Description 拦截器
 * @Author Coolance
 * @Version
 * @Date 2019/8/17 22:33
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("TimeInterceptor preHandle");
        request.setAttribute("start", System.currentTimeMillis());
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod)handler).getMethod().getName());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("TimeInterceptor postHandle");
        Long start = (Long)request.getAttribute("start");
        System.out.println("time interceptor 耗时:"+ (System.currentTimeMillis() - start));

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("TimeInterceptor afterCompletion");
        Long start = (Long)request.getAttribute("start");
        System.out.println("time interceptor 耗时:"+ (System.currentTimeMillis() - start));
        System.out.println("ex is " + ex);

    }
}
