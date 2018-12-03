package com.pinyougou.goods.service;

import com.pinyougou.goods.dao.entity.Brand;

import java.util.List;
import java.util.Map;

/**
 * @author ljn
 * @date 2018/11/6.
 */
public interface IBrandService {

    List<Brand> getAllBrand();

    void createBrand(Brand brand);

    void updateBrand(Brand brand);

    Brand findById(Long id);

    void batchDelete(List<Long> ids);

    List<Brand> selectByMap(Map<String,Object> map,String orderBy,boolean isAsc);

    List<Map> selectOptionList();
}
