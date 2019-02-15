package com.pinyougou.goods.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author ljn
 * @date 2019/2/15.
 */
@Service
public class GoodsRedis {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void add() {
        stringRedisTemplate.opsForValue().set("goods","text");
    }

    public void delete() {
        stringRedisTemplate.delete("goods");
    }

    public String get() {
        return stringRedisTemplate.opsForValue().get("goods");
    }
}
