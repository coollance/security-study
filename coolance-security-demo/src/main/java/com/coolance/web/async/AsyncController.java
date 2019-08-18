package com.coolance.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * @ClassName AsyncController
 * @Description 异步请求
 * @Author Coolance
 * @Version
 * @Date 2019/8/18 9:13
 */
@RestController
public class AsyncController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @GetMapping("/order1")
    public Callable<String> order1() {
        logger.info("main thread start");
        Callable<String> result = () -> {
            logger.info("async thread start");
            Thread.sleep(1000);
            logger.info("async thread end");
            return "success";
        };
        logger.info("main thread end");
        return result;
    }

    @GetMapping("/order2")
    public DeferredResult<String> order2() {
        logger.info("main thread start");
        String orderNo = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNo);
        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNo, result);
        logger.info("main thread end");
        return result;
    }
}
