package com.pinyougou.service;

import com.pinyougou.dao.entity.Brand;

import java.util.List;

/**
 * @author ljn
 * @date 2018/11/6.
 */
public interface IBrandService {

    List<Brand> getAllBrand();

    void createBrand(Brand brand);
}
