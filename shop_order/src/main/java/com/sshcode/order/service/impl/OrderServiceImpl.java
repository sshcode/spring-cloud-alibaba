package com.sshcode.order.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sshcode.model.OrderVO;
import com.sshcode.order.dao.OrderMapper;
import com.sshcode.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sshcode
 * @description 订单service实现类
 * @date 2021/8/23 0023
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     *
     * @param orderVO
     * @return
     */
    @Override
//    @SentinelResource(value = "orderVO", blockHandler = "blockHandler", fallback = "fallback")
    public OrderVO createOrder(OrderVO orderVO) {
//        return orderMapper.createOrder(orderVO);
        return orderVO;
    }

    @Override
    @SentinelResource(value = "message", blockHandler = "blockHandler", fallback = "fallback")
    public String message(String message){
        return "调用了";
    }

    public String fallback(String message, Throwable throwable){
         log.info("抛出异常", throwable);
        return "Throwable";
    }

    //blockHandler 当前方法要求跟原方法参数一致
    public String blockHandler(String message, BlockException e){
        log.error("抛出异常", e);
        return "BlockException";
    }

}
