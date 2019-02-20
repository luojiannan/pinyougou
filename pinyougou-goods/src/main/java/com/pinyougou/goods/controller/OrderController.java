package com.pinyougou.goods.controller;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.goods.dao.entity.Order;
import com.pinyougou.goods.service.IOrderService;
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
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("addOrder")
    @ApiOperation(value="生成订单", notes="生成订单")
    public BaseResponse addOrder(@RequestBody String paymentType) {
        BaseResponse response = new BaseResponse();
        try{
            Order order = orderService.addOrder(paymentType);
            response.setResult(order);
        }catch (Exception e) {
            e.printStackTrace();
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
