package com.pinyougou.user.service;


import com.pinyougou.user.dao.entity.User;

/**
 * @author ljn
 * @date 2018/12/20.
 */
public interface IUserService {

    User findByName(String userName);

    User login(String userName, String password);

    void getSmsCode(String phoneNum);

    void register(String userName,String password,String code,String phoneNum);
}
