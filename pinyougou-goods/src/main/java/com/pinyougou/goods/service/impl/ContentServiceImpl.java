package com.pinyougou.goods.service.impl;

import com.pinyougou.goods.dao.entity.Content;
import com.pinyougou.goods.dao.mapper.ContentCategoryMapper;
import com.pinyougou.goods.dao.mapper.ContentMapper;
import com.pinyougou.goods.service.IContentService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author ljn
 * @date 2019/2/15.
 */
@Service
public class ContentServiceImpl implements IContentService{

    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private ContentCategoryMapper contentCategoryMapper;

    @Override
    public List<Content> findByCategoryId(Long id) {
//        PageHelper.startPage(1, 20);
        Example example = new Example(Content.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status","1");
        criteria.andEqualTo("categoryId",id);
        example.setOrderByClause("sort_order asc");
        return contentMapper.selectByExampleAndRowBounds(example, new RowBounds(0, 20));
    }
}
