/**
 *
 */
package com.coolance.security.rbac.init;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

/**
 * @ClassName DataInitializer
 * @Description 系统初始化器
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
@Component
public class SystemDataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * 系统中所有的{@link DataInitializer}接口实现
     */
    @Autowired(required = false)
    private List<DataInitializer> dataInitializerList;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 循环调用系统中所有的{@link DataInitializer}
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (CollectionUtils.isNotEmpty(dataInitializerList)) {

            dataInitializerList.sort(Comparator.comparing(DataInitializer::getIndex));

            dataInitializerList.stream().forEach(dataInitializer -> {
                try {
                    dataInitializer.init();
                } catch (Exception e) {
                    logger.info("系统数据初始化失败(" + dataInitializer.getClass().getSimpleName() + ")", e);
                }
            });
        }
    }

}
