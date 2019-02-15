package com.pinyougou.goods.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.pinyougou.goods.dao.entity.Content;
import com.pinyougou.goods.dao.mapper.ContentCategoryMapper;
import com.pinyougou.goods.dao.mapper.ContentMapper;
import com.pinyougou.goods.service.IContentService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
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

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public final static String CONTENT_KEY = "CONTENT_KEY";

    @Override
    public List<Content> findByCategoryId(Long id) {
        Object content = stringRedisTemplate.boundHashOps(ContentServiceImpl.CONTENT_KEY).get(id+"");
        List<Content> list = null;
        if (content != null) {
            list = JSONObject.parseArray((String) content, Content.class);
        }
        if (CollectionUtils.isEmpty(list)) {
            Example example = new Example(Content.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("status","1");
            criteria.andEqualTo("categoryId",id);
            example.setOrderByClause("sort_order asc");
            list = contentMapper.selectByExampleAndRowBounds(example, new RowBounds(0, 20));
            if (!CollectionUtils.isEmpty(list)) {
                String json = JSONObject.toJSONString(list);
                stringRedisTemplate.boundHashOps(ContentServiceImpl.CONTENT_KEY).put(id+"", json);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public void addContent(Content content) {
        contentMapper.insert(content);
        stringRedisTemplate.boundHashOps(ContentServiceImpl.CONTENT_KEY).delete(content.getId()+"");
    }
}
