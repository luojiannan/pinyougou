package com.pinyougou.controller.brand;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.dto.BrandDTO;
import com.pinyougou.feign.IBrandFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("createBrand")
    @ApiOperation(value="新增品牌", notes="新增品牌")
    public BaseResponse createBrand(@RequestBody BrandDTO brandDTO) {
        return brandFeign.createBrand(brandDTO);
    }

    @GetMapping("deleteById")
    @ApiOperation(value="删除品牌", notes="删除品牌")
    public BaseResponse deleteById(@RequestParam(value = "id") Long id) {
        return brandFeign.deleteById(id);
    }
}
