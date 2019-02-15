package com.pinyougou.goods.service;

import com.pinyougou.goods.dao.entity.Content;

import java.util.List;

/**
 * @author ljn
 * @date 2019/2/15.
 */
public interface IContentService {

    List<Content> findByCategoryId(Long id);

    void addContent(Content content);
}
