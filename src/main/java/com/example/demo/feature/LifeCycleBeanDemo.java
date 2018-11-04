package com.example.demo.feature;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 对应的配置，在xml中配置 init-method 和 destroy-method。
 */
@Slf4j
@Component
public class LifeCycleBeanDemo implements Runnable, InitializingBean, DisposableBean {

    private static int TIMES = 100;

    @Override
    public void afterPropertiesSet() throws Exception {
        Thread runner = new Thread(this);
        runner.setName("Runner-LifeCycleBeanDemo");
        runner.start();
        log.debug("--> LifeCycleBeanDemo 初始化完成 ");
    }

    @Override
    public void destroy() throws Exception {
        log.debug("--> LifeCycleBeanDemo 销毁完成 ");
    }

    @Override
    public void run() {
        while (TIMES > 0) {
            log.debug("count {}", TIMES);
            TIMES--;
            if(TIMES ==0) {
                log.debug("runner stopped");
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                log.error("LifeCycleBeanDemo interrupted: {}", e);
            }
        }
    }
}
