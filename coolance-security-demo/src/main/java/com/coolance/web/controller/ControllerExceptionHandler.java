package com.coolance.web.controller;

import com.coolance.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ControllerExceptionHandler
 * @Description 异常处理切面
 * @Author Coolance
 * @Version
 * @Date 2019/8/17 21:39
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    //@ResponseBody
    public ResponseEntity<Map<String, Object>> handleUserNotExistException(UserNotExistException ex) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("id", ex.getId());
        map.put("message", ex.getMessage());
        ResponseEntity<Map<String, Object>> entity = new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }
}
