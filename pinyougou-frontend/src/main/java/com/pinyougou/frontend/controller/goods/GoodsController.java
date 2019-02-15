package com.pinyougou.frontend.controller.goods;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.frontend.feign.IGoodsFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljn
 * @date 2019/2/15.
 */
@RestController
@RequestMapping("frontend/goods")
public class GoodsController {

    @Autowired
    IGoodsFeign goodsFeign;

    /**
     * 返回全部列表
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation(value="返回全部商品列表", notes="返回全部商品列表")
    public BaseResponse findAll() {
        return goodsFeign.findAll();
    }
}
