package com.pinyougou.common.mapper;


import com.pinyougou.common.entity.BaseEntity;
import tk.mybatis.mapper.common.Mapper;

public interface IBaseMapper<T extends BaseEntity> extends Mapper<T> {

}
