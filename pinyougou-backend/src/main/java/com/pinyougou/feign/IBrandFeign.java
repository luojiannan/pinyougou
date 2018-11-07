package com.pinyougou.feign;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.dto.BrandDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ljn
 * @date 2018/11/6.
 */
@FeignClient("goods-server")
public interface IBrandFeign {

    @RequestMapping(value = "brand/getAll", method = RequestMethod.GET)
    BaseResponse getBrand();

    @RequestMapping(value = "brand/getBrandList", method = RequestMethod.GET)
    BaseResponse getBrandList(@RequestParam("page")int page,@RequestParam("size")int size);

    @RequestMapping(value = "brand/createBrand", method = RequestMethod.GET)
    BaseResponse createBrand(@RequestBody BrandDTO brand);

    @RequestMapping(value = "brand/deleteById", method = RequestMethod.GET)
    BaseResponse deleteById(@RequestParam("id")long id);

}
