package com.coolance.web.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @ClassName QueueListener
 * @Description 消息队列监听器
 * @Author Coolance
 * @Version
 * @Date 2019/8/18 9:39
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        new Thread(() -> {
            while(true) {
                if(StringUtils.isNotBlank(mockQueue.getCompleteOrder())) {
                    String orderNo = mockQueue.getCompleteOrder();
                    logger.info("返回订单处理结果" + orderNo);
                    deferredResultHolder.getMap().get(mockQueue.getCompleteOrder()).setResult("place order success");
                    mockQueue.setCompleteOrder(null);
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
