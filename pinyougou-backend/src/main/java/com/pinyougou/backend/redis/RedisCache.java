package com.pinyougou.backend.redis;

import org.crazycake.shiro.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author ljn
 * @date 2019/1/18.
 */
@Component
public class RedisCache extends RedisManager{

    @Autowired
    private RedisTemplate redisTemplate;

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
