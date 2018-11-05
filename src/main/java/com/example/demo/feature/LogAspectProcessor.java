package com.example.demo.feature;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspectProcessor implements InitializingBean {

    @Pointcut("@annotation(com.example.demo.annotation.LogAspect)")
    public void logPointcut() {

    }

    @Around("logPointcut()")
    public Object execAnotation(ProceedingJoinPoint jp) {
        log.debug("LogAspect enter ");
        try {
            jp.proceed();
        } catch (Throwable throwable) {
            log.error("LogAspect throwable ", throwable);
        } finally {
            log.debug("LogAspect quit ");
        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("LogAspectProcessor 初始化完成 ");
    }
}
