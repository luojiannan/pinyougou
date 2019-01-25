package com.pinyougou.goods.dao.mapper;

import com.pinyougou.goods.dao.entity.ItemCat;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author ljn
 */
@Repository
public interface ItemCatMapper extends Mapper<ItemCat> {

    void batchDelete(List<Long>ids);
}