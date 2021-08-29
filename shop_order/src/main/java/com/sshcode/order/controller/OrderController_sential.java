package com.sshcode.order.controller;

import com.alibaba.fastjson.JSON;
import com.sshcode.model.OrderVO;
import com.sshcode.model.ProductVO;
import com.sshcode.order.service.OrderService;
import com.sshcode.order.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @description 订单
 * @date 2021/8/23 0023
 */
@RestController
@Slf4j
public class OrderController_sential {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
        private RocketMQTemplate rocketMQTemplate; //使用rocketmqtemplate

    @RequestMapping("/order/prod/{pid}")
    public OrderVO createOrder(@PathVariable("pid") Integer pid) {
        log.info("商品创建成功，购买的商品{},接下来调用商品微服务查询此商品", pid);
        // 调用商品微服务
        ProductVO productVO = productService.finById(pid);
        if(productVO.getPid() == -100){
            OrderVO orderVO = new OrderVO();
//        orderService.createOrder(orderVO);
            log.info("创建订单成功，订单信息为{}", JSON.toJSONString(productVO));
            orderVO.setPname("订单下单失败");
            return orderVO;
        }
        OrderVO orderVO = new OrderVO();
//        orderService.createOrder(orderVO);
        log.info("创建订单成功，订单信息为{}", JSON.toJSONString(productVO));
        orderVO.setPid(productVO.getPid());
        orderVO.setPname(productVO.getPanme());
        orderVO.setPprice(productVO.getPprice());
        // 参数1 指定toptic 参数2 指定消息体
        rocketMQTemplate.convertAndSend("order_topic", orderVO);
        return orderVO;
    }

    /**
     * 测试高并发
     * @return
     */
    @RequestMapping("/order/message1")
    public String message(){
        orderService.message("调用了");
        return "测试高并发";
    }

    @RequestMapping("/order/message2")
    public String message2 (){
        return "测试高并发";
    }
}
