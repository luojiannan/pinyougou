package com.pinyougou.controller.brand;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.feign.IBrandFeign;
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
    public BaseResponse getBrand() {
        return brandFeign.getBrand();
    }

    @GetMapping("getBrandList")
    public BaseResponse getBrand(@RequestParam("page") int page, @RequestParam("size") int size) {
        return brandFeign.getBrandList(page,size);
    }
}
