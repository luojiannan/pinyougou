package com.pinyougou.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.user.dao.entity.User;
import com.pinyougou.user.dao.mapper.UserMapper;
import com.pinyougou.user.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private IUserService userService;

    @GetMapping("findByName")
    @ApiOperation(value="根据用户名获取用户", notes="根据用户名获取用户")
    public BaseResponse findByName(@RequestParam String userName) {
        BaseResponse response = new BaseResponse();
        try {
            if (StringUtils.isBlank(userName)) {
                throw new RuntimeException("用户名称不能为空");
            }
            User user = userService.findByName(userName);
            response.setResult(user);
        }catch (RuntimeException e) {
            e.printStackTrace();
            response.setErrorMessage(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping("register")
    @ApiOperation(value="注册", notes="注册")
    public BaseResponse register(String userName,String password,String code,String phoneNum){
        BaseResponse response = new BaseResponse();
        try{
            userService.register(userName, password, code, phoneNum);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping("getSmsCode")
    @ApiOperation(value="获取短信验证码", notes="获取短信验证码")
    public BaseResponse getSmsCode(String phoneNum){
        BaseResponse response = new BaseResponse();
        try{
            userService.getSmsCode(phoneNum);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
