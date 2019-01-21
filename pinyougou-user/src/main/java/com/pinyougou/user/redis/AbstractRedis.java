package com.pinyougou.user.redis;

import org.springframework.data.redis.core.*;

import javax.annotation.PostConstruct;

/**
 * @author ljn
 * @date 2019/1/21.
 */
public abstract class AbstractRedis {

    protected ValueOperations<String, String> valueOps;

    protected ListOperations<String, String> listOps;

    protected SetOperations<String, String> setOps;

    protected ZSetOperations<String, String> zSetOps;

    @PostConstruct
    public void afterInit(){
        valueOps = getTemplate().opsForValue();
        listOps = getTemplate().opsForList();
        setOps = getTemplate().opsForSet();
        zSetOps = getTemplate().opsForZSet();
    }

    /**
     * 获取子类中实现的template
     * @return
     */
    public abstract StringRedisTemplate getTemplate();
}
