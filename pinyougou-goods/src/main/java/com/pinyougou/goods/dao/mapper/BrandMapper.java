package com.pinyougou.goods.dao.mapper;

import com.pinyougou.goods.dao.entity.Brand;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author ljn
 */

@Repository
public interface BrandMapper extends Mapper<Brand> {

    List<Brand> selectByMap(Map<String,Object> map);

    List<Map> selectOptionList();
}