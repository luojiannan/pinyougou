package com.pinyougou.user.service.impl;

import com.pinyougou.user.dao.entity.User;
import com.pinyougou.user.dao.mapper.UserMapper;
import com.pinyougou.user.redis.UserRedis;
import com.pinyougou.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author ljn
 * @date 2018/12/20.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRedis userRedis;


    @Override
    public User findByName(String userName) {
        User user = userRedis.get(userName);
        if (user == null) {
            user = userMapper.selectByName(userName);
            userRedis.add(user);
        }
        return user;
    }

    @Override
    public User login(String userName, String password) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", userName);
        criteria.andEqualTo("password", password);
        return userMapper.selectOneByExample(example);
    }

    @Override
    public void getSmsCode(String phoneNum) {
        String code = (long)(Math.random() * 1000000) + "";
        userRedis.addRegisterCode(phoneNum, code);
        // TODO: 2019/2/19 调用阿里大于发送短信
    }

    @Override
    public void register(String userName,String password,String code,String phoneNum) {
        String registerCode = userRedis.getRegisterCode(phoneNum);
        if (!code.equals(registerCode)) {
            throw new RuntimeException("短信验证码错误");
        }
        /*
        校验用户名是否合法
         */
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setPhone(phoneNum);
        user.setCreated(new Date());
        userMapper.insert(user);
    }


}
