package com.pinyougou.feign;

import com.pinyougou.common.dto.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ljn
 * @date 2018/11/6.
 */
@FeignClient("goods-server")
public interface IBrandFeign {

    @RequestMapping(value = "brand/getAll", method = RequestMethod.GET)
    BaseResponse getBrand();
}
