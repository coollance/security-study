/**
 *
 */
package com.coolance.security.rbac.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName AbstractDataInitializer
 * @Description 抽象数据初始化器，所有的数据初始化器应该继承此类
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
public abstract class AbstractDataInitializer implements DataInitializer {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * (non-Javadoc)
     *
     * @see com.coolance.security.rbac.init.DataInitializer#init()
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void init() throws Exception {
        if (isNeedInit()) {
            logger.info("使用" + getClass().getSimpleName() + "初始化数据");
            doInit();
            logger.info("使用" + getClass().getSimpleName() + "初始化数据完毕");
        }
    }

    /**
     * 实际的数据初始化逻辑
     * @throws Exception
     */
    protected abstract void doInit() throws Exception;

    /**
     * 是否执行数据初始化行为
     *
     * @return
     */
    protected abstract boolean isNeedInit();

}
