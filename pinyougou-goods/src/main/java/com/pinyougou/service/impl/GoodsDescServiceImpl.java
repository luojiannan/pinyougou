package com.pinyougou.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.dao.entity.GoodsDesc;
import com.pinyougou.dao.mapper.GoodsDescMapper;
import com.pinyougou.service.IGoodsDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
public class GoodsDescServiceImpl implements IGoodsDescService {

    @Autowired
    private GoodsDescMapper goodsDescMapper;

    /**
     * 查询全部
     */
    @Override
    public List<GoodsDesc> findAll() {
        return goodsDescMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public Page findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return (Page<GoodsDesc>) goodsDescMapper.selectByExample(null);
    }

    /**
     * 增加
     */
    @Override
    public void add(GoodsDesc goodsDesc) {
        goodsDescMapper.insert(goodsDesc);
    }


    /**
     * 修改
     */
    @Override
    public void update(GoodsDesc goodsDesc) {
        goodsDescMapper.updateByPrimaryKey(goodsDesc);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public GoodsDesc findOne(Long id) {
        return goodsDescMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            goodsDescMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public Page findPage(GoodsDesc goodsDesc, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(GoodsDesc.class);
        Example.Criteria criteria = example.createCriteria();
        if (goodsDesc != null) {
            if (goodsDesc.getIntroduction() != null && goodsDesc.getIntroduction().length() > 0) {
                criteria.andLike("introduction","%" + goodsDesc.getIntroduction() + "%");
            }
            if (goodsDesc.getSpecificationItems() != null && goodsDesc.getSpecificationItems().length() > 0) {
                criteria.andLike("specificationItems","%" + goodsDesc.getSpecificationItems() + "%");
            }
            if (goodsDesc.getCustomAttributeItems() != null && goodsDesc.getCustomAttributeItems().length() > 0) {
                criteria.andLike("customAttributeItems","%" + goodsDesc.getCustomAttributeItems() + "%");
            }
            if (goodsDesc.getItemImages() != null && goodsDesc.getItemImages().length() > 0) {
                criteria.andLike("itemImages","%" + goodsDesc.getItemImages() + "%");
            }
            if (goodsDesc.getPackageList() != null && goodsDesc.getPackageList().length() > 0) {
                criteria.andLike("packageList","%" + goodsDesc.getPackageList() + "%");
            }
            if (goodsDesc.getSaleService() != null && goodsDesc.getSaleService().length() > 0) {
                criteria.andLike("saleService","%" + goodsDesc.getSaleService() + "%");
            }

        }

        Page<GoodsDesc> page = (Page<GoodsDesc>) goodsDescMapper.selectByExample(example);
        return page;
    }

}
