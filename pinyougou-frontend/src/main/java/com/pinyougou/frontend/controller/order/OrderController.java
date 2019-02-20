package com.pinyougou.frontend.controller.order;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.frontend.feign.IOrderFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljn
 * @date 2019/2/20.
 */
@RestController
@RequestMapping("frontend/order")
public class OrderController {

    @Autowired
    private IOrderFeign orderFeign;

    @PostMapping("addOrder")
    @ApiOperation(value="新增订单", notes="新增订单")
    public BaseResponse addOrder(@RequestBody String paymentType) {
        BaseResponse response = orderFeign.addOrder(paymentType);
        return response;

    }
}
