package com.pinyougou.frontend.feign;

import com.pinyougou.common.dto.BaseResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ljn
 * @date 2019/2/15.
 */
@FeignClient("goods-server")
@Component
public interface IGoodsFeign {

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping(value = "goods/findAll", method = RequestMethod.GET)
    @ApiOperation(value="返回全部商品列表", notes="返回全部商品列表")
    BaseResponse findAll();
}
