package com.pinyougou.frontend.feign;

import com.pinyougou.common.dto.BaseResponse;
import org.springframework.stereotype.Component;

/**
 * 熔断访问类
 */
@Component
public class GoodsFeignFallBack implements IGoodsFeign {
    @Override
    public BaseResponse findAll() {
        return null;
    }

    @Override
    public BaseResponse findByCategoryId(Long categoryId) {
        return null;
    }
}
