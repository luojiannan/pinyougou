package com.pinyougou.goods.service;

import com.pinyougou.goods.dao.entity.Order;

/**
 * @author ljn
 * @date 2019/2/19.
 */
public interface IOrderService {

    Order addOrder(String paymentType);
}
