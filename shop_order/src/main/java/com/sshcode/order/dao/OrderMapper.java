package com.sshcode.order.dao;

import com.sshcode.model.OrderVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author sshcode
 * @description 订单dao
 * @date 2021/8/23 0023
 */
@Mapper
public interface OrderMapper {

    OrderVO createOrder(OrderVO orderVO);
}
