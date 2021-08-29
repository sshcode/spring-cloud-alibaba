package com.sshcode.order.service.impl;

import com.sshcode.model.OrderVO;
import com.sshcode.model.TxLogVO;
import com.sshcode.order.dao.TxLogMapper;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

/**
 * @author sshcode
 * @description RocketMq测试
 * @date 2021/8/26 0026
 */
public class OrderServiceImplTransListener implements RocketMQLocalTransactionListener {

    @Autowired
    private OrderServiceImplTrans orderServiceImplTrans;
    @Autowired
    private TxLogMapper txLogMapper;

    /**
     * 执行本地事务
     * @param message
     * @param o
     * @return
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        //本地事务
        String txId =(String) message.getHeaders().get("txId");
        try {
            OrderVO orderVO = (OrderVO) o;
            orderServiceImplTrans.createOrder(txId,orderVO);
            return RocketMQLocalTransactionState.COMMIT;
        }catch (Exception e){
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    /**
     * 消息回查
     * @param message
     * @return
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        String txId =(String) message.getHeaders().get("txId");
        TxLogVO txLogVO = txLogMapper.findById(txId);
        if(txLogVO != null){
            // 本地事务（订单）成功了
            return RocketMQLocalTransactionState.COMMIT;
        }else{
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }
}
