package com.pinyougou.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.dao.entity.Brand;
import com.pinyougou.dao.mapper.BrandMapper;
import com.pinyougou.service.IBrandService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ljn
 * @date 2018/11/6.
 */
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @Autowired
    private BrandMapper brandMapper;

    @GetMapping("getAll")
    @ApiOperation(value="查询所有品牌", notes="查询所有品牌")
    public BaseResponse getAllBrand(){
        BaseResponse response = new BaseResponse();
        List<Brand> brands = brandService.getAllBrand();
        response.setData(brands);
        return response;
    }

    @GetMapping("getBrandList")
    @ApiOperation(value="分页查询品牌", notes="分页查询品牌")
    public BaseResponse getBrandList(@RequestParam("page") int page, @RequestParam("size") int size){
        BaseResponse response = new BaseResponse();
        PageHelper.startPage(page, size);
        Page<Brand> pages = (Page<Brand>) brandMapper.selectByExample(null);
        response.setTotalCount(pages.getTotal());
        response.setData(pages.getResult());
        return response;
    }
}
