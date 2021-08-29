package com.sshcode.service.rocket;

import com.sshcode.model.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author sshcode
 * @description 消息消费端
 * @date 2021/8/26 0026
 */
@Slf4j
@Service
//consumerGroup 消费组名 topic--要消费的主题
@RocketMQMessageListener(
        consumerGroup = "shop_user", //消费者组名
        topic = "order_topic", //消费的主题
        consumeMode = ConsumeMode.ORDERLY,//消费模式，指定是否顺序消费 CONCURRENTLY(同步，默认),ORDERLY(顺序)
        messageModel = MessageModel.CLUSTERING //消息模式 BROADCASTING（广播，每个消费者实例处理）
                                                // CLUSTERING(集群模式，默认，一条消息被一个消费者实例消费 )
)
public class SmsService implements RocketMQListener<OrderVO> {

    /**
     * 消费逻辑
     * @param orderVO
     */
    @Override
    public void onMessage(OrderVO orderVO) {
        log.info("接受一个订单信息（），接下来就可以发送短信通知了");

    }

}
