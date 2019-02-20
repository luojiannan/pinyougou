package com.pinyougou.frontend.feign;

import com.pinyougou.common.dto.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ljn
 * @date 2019/2/20.
 */
@FeignClient("goods-server")
@Component
public interface IOrderFeign {

    @RequestMapping(value="order/addOrder", method = RequestMethod.POST)
    BaseResponse addOrder(@RequestBody String paymentType);
}
