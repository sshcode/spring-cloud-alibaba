package com.sshcode.order.service.impl;

import com.sshcode.model.OrderVO;
import com.sshcode.service.QueryOrderService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author sshcode
 * @description 订单查询服务
 * @date 2021/8/27 0027
 */
@Service //注意这个需要使用dubbo提供的
public class QueryOrderServiceImpl implements QueryOrderService {

    @Override
    public OrderVO findOrderVO(Integer oid) {
        return null;
    }
}
