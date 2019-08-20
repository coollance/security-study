package com.coolance.security.browser.support;

import lombok.Data;

/**
 * @ClassName SimpleResponse
 * @Description 返回类型包装类
 * @Author Coolance
 * @Version
 * @Date 2019/8/20 10:13
 */
@Data
public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }
}
