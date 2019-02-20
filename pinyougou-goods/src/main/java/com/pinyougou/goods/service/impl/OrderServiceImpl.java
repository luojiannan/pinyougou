package com.pinyougou.goods.service.impl;

import com.pinyougou.goods.dao.entity.Order;
import com.pinyougou.goods.dao.mapper.OrderMapper;
import com.pinyougou.goods.enums.OrderStatus;
import com.pinyougou.goods.enums.PaymentType;
import com.pinyougou.goods.service.IOrderService;
import com.pinyougou.goods.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ljn
 * @date 2019/2/19.
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Order addOrder(String paymentType) {
        Order order = new Order();
        IdWorker worker = new IdWorker();
        order.setOrderId(worker.nextId());
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        order.setPaymentType(PaymentType.getPaymentTypeByCode(paymentType).getCode());
        order.setStatus(OrderStatus.WaitPayment.getCode());
        order.setUserId("tulufan");
        order.setPayment(new BigDecimal(5299.00));
        order.setSellerId("afanti");
        order.setReceiver("孙思邈");
        order.setReceiverAreaName("花田");
        orderMapper.insert(order);
        return order;
    }
}
