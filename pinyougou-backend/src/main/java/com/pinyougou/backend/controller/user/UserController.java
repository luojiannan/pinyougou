package com.pinyougou.backend.controller.user;

import com.pinyougou.backend.dto.User;
import com.pinyougou.backend.feign.IUserFeign;
import com.pinyougou.common.dto.BaseResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    public BaseResponse<User> findByName(String userName) {
        return userFeign.findByName(userName);
    }

    @GetMapping("login")
    @ApiOperation(value="登录", notes="登录")
    public BaseResponse login(String userName, String password) {
        BaseResponse response = new BaseResponse();
        try {
            if (StringUtils.isBlank(userName)) {
                throw new RuntimeException("用户名称不能为空");
            }
            if (StringUtils.isBlank(password)) {
                throw new RuntimeException("用户密码不能为空");
            }
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
            subject.login(usernamePasswordToken);
            response.setMessage("登录成功");
        }catch (RuntimeException e) {
            e.printStackTrace();
            response.setErrorMessage(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            response.setErrorMessage("用户名或密码错误");
        }
        return response;
    }

    @GetMapping("logout")
    @ApiOperation(value="用户退出登录", notes="用户退出登录")
    public BaseResponse logout() {
        BaseResponse response = new BaseResponse();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        }catch (RuntimeException e) {
            e.printStackTrace();
            response.setErrorMessage(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }
}
