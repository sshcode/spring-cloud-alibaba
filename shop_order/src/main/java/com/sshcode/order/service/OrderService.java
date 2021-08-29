package com.sshcode.order.service;

import com.sshcode.model.OrderVO;

/**
 * @author
 * @description 订单service
 * @date 2021/8/23 0023
 */
public interface OrderService {

    OrderVO createOrder(OrderVO orderVO);

    String message(String message);
}
