package com.pinyougou.dao.mapper;

import com.pinyougou.dao.entity.SpecificationOption;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @author ljn
 */

@Component
public interface SpecificationOptionMapper extends Mapper<SpecificationOption> , InsertListMapper<SpecificationOption> {
}