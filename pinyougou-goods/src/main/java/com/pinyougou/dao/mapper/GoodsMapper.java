package com.pinyougou.dao.mapper;

import com.pinyougou.dao.entity.Goods;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author ljn
 */
@Component
public interface GoodsMapper extends Mapper<Goods> {

    List<Goods> selectByMap(Map<String,Object> map);
}