package com.pinyougou.goods.controller;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.goods.dao.entity.User;
import com.pinyougou.goods.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljn
 * @date 2018/12/20.
 */
@RestController
@RequestMapping("user")
public class UserController {

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

    @GetMapping("login")
    @ApiOperation(value="用户登录", notes="用户登录")
    public BaseResponse login(String userName, String password) {
        BaseResponse response = new BaseResponse();
        try {
            if (StringUtils.isBlank(userName)) {
                throw new RuntimeException("用户名称不能为空");
            }
            if (StringUtils.isBlank(password)) {
                throw new RuntimeException("用户密码不能为空");
            }
            User user = userService.login(userName, password);
            if (user == null) {
                throw new RuntimeException("登录失败");
            }
            response.setMessage("登录成功");
        }catch (RuntimeException e) {
            e.printStackTrace();
            response.setErrorMessage(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
