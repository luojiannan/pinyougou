package com.pinyougou.goods.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.common.utils.ParamUtils;
import com.pinyougou.goods.dao.entity.Brand;
import com.pinyougou.goods.dto.BrandDTO;
import com.pinyougou.goods.service.IBrandService;
import com.pinyougou.goods.utils.BeanMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ljn
 * @date 2018/11/6.
 */
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @GetMapping("getAll")
    @ApiOperation(value="查询所有品牌", notes="查询所有品牌")
    public BaseResponse getAllBrand(){
        BaseResponse response = new BaseResponse();
        List<Brand> brands = brandService.getAllBrand();
        response.setData(brands);
        return response;
    }

    @PostMapping("getBrandList")
    @ApiOperation(value="分页查询品牌", notes="分页查询品牌")
    public BaseResponse getBrandList(@RequestBody(required = false) BrandDTO brand, Integer page,  Integer size){
        BaseResponse response = new BaseResponse();
        PageHelper.startPage(page, size);
        Map<String, Object> params = new HashMap<>();
        if (brand != null) {
            params = ParamUtils.convertMap(brand);
        }
        Page<Brand> pages = (Page<Brand>) brandService.selectByMap(params,"id",false);
        response.setTotalCount(pages.getTotal());
        response.setData(pages.getResult());
        response.setPageIndex(page);
        response.setPageSize(size);
        return response;
    }

    @PostMapping("createBrand")
    @ApiOperation(value="新增品牌", notes="新增品牌")
    public BaseResponse createBrand(@RequestBody BrandDTO brandDTO) {
        BaseResponse response = new BaseResponse();
        try{
            Brand brand = BeanMapper.map(brandDTO, Brand.class);
            brandService.createBrand(brand);
        }catch (RuntimeException e) {
            response.setCode("01");
            response.setErrorMessage("新增品牌发生错误");
        }
        return response;
    }

    @GetMapping("batchDelete")
    @ApiOperation(value="删除品牌", notes="删除品牌")
    public BaseResponse batchDelete(@RequestParam("ids") List<Long> ids) {
        BaseResponse response = new BaseResponse();
        try{
            brandService.batchDelete(ids);
        }catch (Exception e) {
            response.setCode("01");
            response.setErrorMessage("删除品牌发生错误");
        }
        return response;
    }

    @PostMapping("updateBrand")
    @ApiOperation(value="修改品牌", notes="修改品牌")
    public BaseResponse updateBrand(@RequestBody BrandDTO brandDTO) {
        BaseResponse response = new BaseResponse();
        try{
            Brand brand = BeanMapper.map(brandDTO, Brand.class);
            brandService.updateBrand(brand);
        }catch (Exception e) {
            response.setCode("01");
            response.setErrorMessage("修改品牌发生错误");
        }
        return response;
    }

    @GetMapping("findById")
    @ApiOperation(value="修改品牌", notes="修改品牌")
    public BaseResponse findById(@RequestParam("id") long id) {
        BaseResponse response = new BaseResponse();
        try{
            Brand brand = brandService.findById(id);
            response.setResult(brand);
        }catch (Exception e) {
            response.setCode("01");
            response.setErrorMessage("修改品牌发生错误");
        }
        return response;
    }
}
