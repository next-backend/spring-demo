package com.example.demo.cache;

import com.example.demo.annotation.LogAspect;

public interface CacheService {
    /**
     *
     * @param key
     * @return
     */
    <T> T get(String key, Class<T> clazz);

    @LogAspect
    String get(String key);

    /**
     * 往Redis里面增加键值对
     * @param key
     * @param value
     * @param ttl
     * @return
     */
    void set(String key, String value, long ttl);

    /**
     * 删除键值对
     *
     * @param key
     * @return
     */
    void del(String key);
}
