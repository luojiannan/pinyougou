package com.pinyougou.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.dao.entity.Brand;
import com.pinyougou.dao.mapper.BrandMapper;
import com.pinyougou.dto.BrandDTO;
import com.pinyougou.service.IBrandService;
import com.pinyougou.utils.BeanMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("deleteById")
    @ApiOperation(value="删除品牌", notes="删除品牌")
    public BaseResponse deleteById(@RequestParam("id") long id) {
        BaseResponse response = new BaseResponse();
        try{
            brandMapper.deleteByPrimaryKey(id);
        }catch (RuntimeException e) {
            response.setCode("01");
            response.setErrorMessage("删除品牌发生错误");
        }
        return response;
    }
}
