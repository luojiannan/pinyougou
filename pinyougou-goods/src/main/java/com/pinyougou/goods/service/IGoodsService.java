package com.pinyougou.goods.service;

import com.github.pagehelper.Page;
import com.pinyougou.goods.dao.entity.Goods;
import com.pinyougou.goods.dto.GoodsDTO;

import java.util.List;
import java.util.Map;

/**
 * @author ljn
 * @date 2018/11/6.
 */
public interface IGoodsService {

    /**
     * 返回全部列表
     * @return
     */
    List<Goods> findAll();


    /**
     * 返回分页列表
     * @return
     */
    Page findPage(int pageNum, int pageSize);


    /**
     * 增加
     */
    void add(GoodsDTO goodsDTO);


    /**
     * 修改
     */
    void update(Goods goods);


    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    Goods findOne(Long id);


    /**
     * 批量删除
     * @param ids
     */
    void delete(Long [] ids);

    /**
     * 分页
     * @return
     */
    List<Goods> findPage(Map<String,Object> map,String orderBy,boolean isAsc);
}
