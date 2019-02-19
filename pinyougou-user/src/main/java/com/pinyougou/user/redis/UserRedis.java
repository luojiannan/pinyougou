package com.pinyougou.user.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pinyougou.user.dao.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author ljn
 * @date 2019/1/21.
 */
@Component("dispenseConsumer")
public class UserRedis extends AbstractRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String prefix = "user:userName:";

    @Override
    public StringRedisTemplate getTemplate() {
        return stringRedisTemplate;
    }

    public void add(User user) {
        String json = JSON.toJSONString(user);
        valueOps.set(prefix + user.getUsername(), json);
    }

    public void delete(String userName) {
        stringRedisTemplate.delete(prefix + userName);
    }

    public User get(String userName) {
        String json = valueOps.get(prefix + userName);
        if (StringUtils.isBlank(json)) {
            return null;
        }
        JSONObject jsonObject = JSONObject.parseObject(json);
        return JSON.toJavaObject(jsonObject, User.class);
    }

    public void addRegisterCode(String phoneNum, String code) {
        valueOps.set("register:" + phoneNum, code);
        stringRedisTemplate.expire("register:" + phoneNum, 1L, TimeUnit.MINUTES);
    }

    public String getRegisterCode(String phoneNum) {
        String code = valueOps.get("register:" + phoneNum);
        return code;
    }
}
