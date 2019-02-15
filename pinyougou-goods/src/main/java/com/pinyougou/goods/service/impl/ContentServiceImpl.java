package com.pinyougou.goods.service.impl;

import com.pinyougou.goods.dao.entity.Content;
import com.pinyougou.goods.dao.mapper.ContentCategoryMapper;
import com.pinyougou.goods.dao.mapper.ContentMapper;
import com.pinyougou.goods.service.IContentService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Content content = new Content();
        content.setCategoryId(id);
        return contentMapper.selectByRowBounds(content, new RowBounds(0, 20));
    }
}
