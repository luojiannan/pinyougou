package com.pinyougou.controller.brand;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.dto.BrandDTO;
import com.pinyougou.feign.IBrandFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("getBrandList")
    @ApiOperation(value="分页查询品牌", notes="分页查询品牌")
    public BaseResponse getBrandList(@RequestBody(required = false) BrandDTO brandDTO,@RequestParam(value = "page",required = false) Integer page,
                                     @RequestParam(value = "size",required = false) Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size  = 20;
        }
        return brandFeign.getBrandList(brandDTO,page,size);
    }

    @PostMapping("createBrand")
    @ApiOperation(value="新增品牌", notes="新增品牌")
    public BaseResponse createBrand(@RequestBody BrandDTO brand) {
        return brandFeign.createBrand(brand);
    }

    @GetMapping("batchDelete")
    @ApiOperation(value="删除品牌", notes="删除品牌")
    public BaseResponse batchDelete(@RequestParam(value = "ids") List<Long> ids) {
        return brandFeign.batchDelete(ids);
    }

    @PostMapping("updateBrand")
    @ApiOperation(value="修改品牌", notes="修改品牌")
    public BaseResponse updateBrand(@RequestBody BrandDTO brandDTO) {
        return brandFeign.updateBrand(brandDTO);
    }

    @GetMapping("findById")
    @ApiOperation(value="根据id查询品牌", notes="根据id查询品牌")
    public BaseResponse findById(@RequestParam("id") long id) {
        return brandFeign.findById(id);

    }
}
