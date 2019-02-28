package com.pinyougou.goods.service.impl;

import com.pinyougou.goods.annotation.AccessLimit;
import com.pinyougou.goods.dao.entity.Brand;
import com.pinyougou.goods.dao.mapper.BrandMapper;
import com.pinyougou.goods.service.IBrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

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
    @AccessLimit
    public void createBrand(Brand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public Brand findById(Long id) {
        Brand brand = new Brand();
        brand.setId(id);
        return brandMapper.selectOne(brand);
    }

    @Override
    public String batchDelete(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return "返回值";
        }
        for (Long id : ids) {
            brandMapper.deleteByPrimaryKey(id);
        }
        return "返回值";
    }

    @Override
    public List<Brand> selectByMap(Map<String, Object> map,String orderBy,boolean isAsc) {
        if (StringUtils.isNotBlank(orderBy)) {
            map.put("ORDERBY",orderBy);
            if (isAsc) {
                map.put("ORDER",true);
            } else {
                map.put("ORDER",false);
            }
        }
        return brandMapper.selectByMap(map);
    }

    @Override
    public List<Map> selectOptionList() {
        return brandMapper.selectOptionList();
    }
}
