package com.coolance.service.impl;

import com.coolance.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @ClassName HelloServiceImpl
 * @Description 自定义校验逻辑类中可以注入服务类
 * @Author Coolance
 * @Version
 * @Date 2019/8/17 18:00
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("HelloServiceImpl greeting");
        return "hello" + name;
    }
}
