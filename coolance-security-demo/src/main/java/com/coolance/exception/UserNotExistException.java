package com.coolance.exception;

/**
 * @ClassName UserNotExistException
 * @Description 自定义异常类
 * @Author Coolance
 * @Version
 * @Date 2019/8/17 21:30
 */
public class UserNotExistException extends RuntimeException {
    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
