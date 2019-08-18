package com.coolance.web.config;

import com.coolance.web.filter.TimeFilter;
import com.coolance.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WebConfig
 * @Description 配置类
 * @Author Coolance
 * @Version
 * @Date 2019/8/17 22:19
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(timeInterceptor);
    }

    //@Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        bean.setUrlPatterns(urls);
        bean.setFilter(new TimeFilter());
        return bean;

    }
}
