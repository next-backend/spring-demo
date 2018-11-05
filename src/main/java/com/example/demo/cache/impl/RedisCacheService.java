package com.example.demo.cache.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.annotation.LogAspect;
import com.example.demo.cache.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisCacheService implements CacheService {

    @Resource
    private StringRedisTemplate template;

    @LogAspect
    @Override
    public <T> T get(String key, Class<T> clazz) {
        try {
            String json = this.getVOps().get(key);
            return JSON.parseObject(json, clazz);
        } catch (Exception e) {
            log.error("Execute get command failure", e);
        }
        return null;
    }

    @LogAspect
    @Override
    public String get(String key) {
        try {
            return this.getVOps().get(key);
        } catch (Exception e) {
            log.error("Execute get command failure", e);
        }
        return null;
    }

    @Override
    public void set(String key, String value, long ttl) {
        this.getVOps().set(key, value, ttl, TimeUnit.SECONDS);
    }

    @Override
    public void del(String key) {
        this.template.delete(key);
    }

    private ValueOperations<String, String> getVOps() {
        return this.template.opsForValue();
    }
}
