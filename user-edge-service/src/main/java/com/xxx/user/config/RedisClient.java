package com.xxx.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Author: JiZhe
 */
@Component
public class RedisClient {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 取值
     * @param key
     * @param <T>
     * @return
     */
    public <T> T get(String key){
        return (T) redisTemplate.opsForValue().get(key);
    }

    /**
     * 存储
     * @param key
     * @param value
     */
    public void set(String key, Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 存储
     * @param key
     * @param value
     * @param timeout
     */
    public void set(String key, Object value, int timeout){
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }


    /**
     * 设置过期时间
     * @param key
     * @param timeout
     */
    public void expire(String key, int timeout){
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }


}
