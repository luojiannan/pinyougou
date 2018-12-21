package com.pinyougou.backend.controller.user;

import com.pinyougou.backend.feign.IUserFeign;
import com.pinyougou.common.dto.BaseResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljn
 * @date 2018/11/6.
 */
@RestController
@RequestMapping("backend/user")
public class UserController {

    @Autowired
    private IUserFeign userFeign;

    @GetMapping("getUser")
    public String getUser(){
        return userFeign.getUser();
    }

    @GetMapping("findByName")
    @ApiOperation(value="根据用户名获取用户", notes="根据用户名获取用户")
    public BaseResponse findByName(String userName) {
        return userFeign.findByName(userName);
    }

    @GetMapping("login")
    @ApiOperation(value="登录", notes="登录")
    public BaseResponse login(String userName, String password) {
        return userFeign.login(userName, password);
    }
}
