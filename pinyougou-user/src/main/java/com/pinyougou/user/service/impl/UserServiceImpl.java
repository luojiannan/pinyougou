package com.pinyougou.user.service.impl;

import com.pinyougou.user.dao.entity.User;
import com.pinyougou.user.dao.mapper.UserMapper;
import com.pinyougou.user.redis.UserRedis;
import com.pinyougou.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
}
