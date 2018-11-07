package com.pinyougou.service.impl;

import com.pinyougou.dao.entity.Brand;
import com.pinyougou.dao.mapper.BrandMapper;
import com.pinyougou.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ljn
 * @date 2018/11/6.
 */
@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> getAllBrand() {
        return brandMapper.selectAll();
    }

    @Override
    public void createBrand(Brand brand) {
        brandMapper.insert(brand);
    }
}
