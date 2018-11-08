package com.pinyougou.feign;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.dto.BrandDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ljn
 * @date 2018/11/6.
 */
@FeignClient("goods-server")
public interface IBrandFeign {

    @RequestMapping(value = "brand/getAll", method = RequestMethod.GET)
    BaseResponse getBrand();

    @RequestMapping(value = "brand/getBrandList", method = RequestMethod.POST)
    BaseResponse getBrandList(@RequestBody(required = false) BrandDTO brandDTO, @RequestParam("page") Integer page, @RequestParam("size") Integer size);

    @RequestMapping(value = "brand/createBrand", method = RequestMethod.POST)
    BaseResponse createBrand(@RequestBody BrandDTO brand);

    @RequestMapping(value = "brand/batchDelete", method = RequestMethod.GET)
    BaseResponse batchDelete(@RequestParam("ids")List<Long> ids);

    @RequestMapping(value = "brand/updateBrand", method = RequestMethod.POST)
    BaseResponse updateBrand(@RequestBody BrandDTO brand);

    @RequestMapping(value = "brand/findById", method = RequestMethod.GET)
    BaseResponse findById(@RequestParam("id")long id);

}
