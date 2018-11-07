package com.pinyougou.controller.brand;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.feign.IBrandFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljn
 * @date 2018/11/6.
 */
@RestController
@RequestMapping("backend/brand")
public class BrandController {

    @Autowired
    private IBrandFeign brandFeign;

    @GetMapping("getBrand")
    @ApiOperation(value="查询所有品牌", notes="查询所有品牌")
    public BaseResponse getBrand() {
        return brandFeign.getBrand();
    }

    @GetMapping("getBrandList")
    @ApiOperation(value="分页查询品牌", notes="分页查询品牌")
    public BaseResponse getBrandList(@RequestParam(value = "page",required = false) Integer page,
                                     @RequestParam(value = "size",required = false) Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size  = 20;
        }
        return brandFeign.getBrandList(page,size);
    }
}
