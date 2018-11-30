package com.pinyougou.goods.dao.mapper;

import com.pinyougou.goods.dao.MyMapper;
import com.pinyougou.goods.dao.entity.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ljn
 */

@Component
public interface SpecificationMapper extends MyMapper<Specification> {

    void batchDelete(List<Long>ids);
}