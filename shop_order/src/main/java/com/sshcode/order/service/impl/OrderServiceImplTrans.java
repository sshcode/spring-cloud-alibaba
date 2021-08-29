package com.sshcode.order.service.impl;

import com.sshcode.model.OrderVO;
import com.sshcode.model.TxLogVO;
import com.sshcode.order.dao.OrderMapper;
import com.sshcode.order.dao.TxLogMapper;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @author sshcode
 * @description RocketMq测试
 * @date 2021/8/26 0026
 */
public class OrderServiceImplTrans {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private TxLogMapper txLogMapper;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    //发送半事务消息
    public void createOrderBefore(OrderVO orderVO){
        String txId = UUID.randomUUID().toString();
        rocketMQTemplate.sendMessageInTransaction("tx_topic",
                MessageBuilder.withPayload(orderVO).setHeader("txId", txId).build(), orderVO);
    }

    @Transactional
    public void createOrder(String txId, OrderVO orderVO){
        // 保存订单
        orderMapper.createOrder(orderVO);
        TxLogVO txLogVO = new TxLogVO();
        txLogVO.setTxId(txId);
        txLogVO.setDate(new Date());
        // 记录事务日志
        txLogMapper.save(txLogVO);
    }
}
