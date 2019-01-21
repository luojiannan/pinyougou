package com.pinyougou.backend.config.shiro;

import org.crazycake.shiro.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author ljn
 * @date 2019/1/18.
 */
@Configuration
public class RedisCache extends RedisManager{

    /**
     * 二进制存储
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 字符串存储
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void add(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
