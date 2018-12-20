package com.pinyougou.goods.service;

import com.pinyougou.goods.dao.entity.User;

/**
 * @author ljn
 * @date 2018/12/20.
 */
public interface IUserService {

    User findByName(String userName);

    User login(String userName, String password);
}
