package com.pinyougou.goods.dao.mapper;

import com.pinyougou.goods.dao.entity.Brand;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author ljn
 */

@Component
public interface BrandMapper extends Mapper<Brand> {

    List<Brand> selectByMap(Map<String,Object> map);
}