package com.pinyougou.controller;

import com.alibaba.fastjson.JSONObject;
import com.pinyougou.dao.entity.Brand;
import com.pinyougou.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("getAll")
    public String getAllBrand(){
        List<Brand> brands = brandService.getAllBrand();
        String json = JSONObject.toJSONString(brands);
        return json;
    }
}
