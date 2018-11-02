package com.pinyougou.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljn
 * @date 2018/11/2.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("getUser")
    public String getUser(){
        return "bruce";
    }
}
