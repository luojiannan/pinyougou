package com.pinyougou.User;

import com.pinyougou.feign.IUserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljn
 * @date 2018/11/6.
 */
@RestController
@RequestMapping("backend")
public class UserController {

    @Autowired
    private IUserFeign userFeign;

    @GetMapping("getUser")
    public String getUser(){
        return userFeign.getUser();
    }
}
