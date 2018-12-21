package com.pinyougou.user.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author ljn
 * @date 2018/11/28.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T>{
}
