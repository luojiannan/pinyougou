package com.pinyougou.frontend.feign;

import com.pinyougou.common.dto.BaseResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ljn
 * @date 2019/2/15.
 */
@FeignClient(value = "goods-server", fallback = GoodsFeignFallBack.class)
//@Component
public interface IGoodsFeign {

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping(value = "goods/findAll", method = RequestMethod.GET)
    @ApiOperation(value="返回全部商品列表", notes="返回全部商品列表")
    BaseResponse findAll();

    /**
     * 根据分类id查询广告
     * @return
     */
    @RequestMapping(value = "content/findByCategoryId", method = RequestMethod.GET)
    @ApiOperation(value="根据分类id查询广告", notes="根据分类id查询广告")
    BaseResponse findByCategoryId(@RequestParam("categoryId") Long categoryId);
}
