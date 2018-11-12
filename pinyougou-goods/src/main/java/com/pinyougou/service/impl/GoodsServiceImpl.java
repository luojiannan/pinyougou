package com.pinyougou.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.dao.entity.Goods;
import com.pinyougou.dao.mapper.GoodsMapper;
import com.pinyougou.service.IGoodsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ljn
 * @date 2018/11/6.
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 查询全部
     */
    @Override
    public List<Goods> findAll() {
        return goodsMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public Page findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Goods> page = (Page<Goods>) goodsMapper.selectByExample(null);
        return page;
    }

    /**
     * 增加
     */
    @Override
    public void add(Goods goods) {
        goodsMapper.insert(goods);
    }


    /**
     * 修改
     */
    @Override
    public void update(Goods goods){
        goodsMapper.updateByPrimaryKey(goods);
    }

    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    @Override
    public Goods findOne(Long id){
        return goodsMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            goodsMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public List<Goods> findPage(Map<String,Object> map,String order,boolean isAsc) {
        if (StringUtils.isNotBlank(order)) {
            map.put("ORDERBY",order);
            if (isAsc) {
                map.put("ORDER",true);
            } else {
                map.put("ORDER",false);
            }
        }
        return goodsMapper.selectByMap(map);
    }
}
