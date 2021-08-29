package com.sshcode.service;

import com.sshcode.model.OrderVO;

/**
 * @author sshcode
 * @description 订单的dubbo查询服务
 * @date 2021/8/27 0027
 */
public interface QueryOrderService {

    OrderVO findOrderVO(Integer oid);
}
