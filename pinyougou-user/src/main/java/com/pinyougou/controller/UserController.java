package com.pinyougou.controller;

import com.alibaba.fastjson.JSONObject;
import com.pinyougou.dao.entity.User;
import com.pinyougou.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ljn
 * @date 2018/11/2.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("getUser")
    public String getUser(){
        List<User> users = userMapper.selectAll();
        String json = JSONObject.toJSONString(users);
        return json;
    }
}
