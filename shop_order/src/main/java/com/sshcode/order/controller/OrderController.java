package com.sshcode.order.controller;

import com.alibaba.fastjson.JSON;
import com.sshcode.model.OrderVO;
import com.sshcode.model.ProductVO;
import com.sshcode.order.service.OrderService;
import com.sshcode.order.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 * @description 订单
 * @date 2021/8/23 0023
 */
//@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;
//    @Autowired
//    private DiscoveryClient discoveryClient;
//    @Autowired
//    private RestOperations restTemplate;

    @Autowired
    private ProductService productService;

    @RequestMapping("/order/prod/{pid}")
    public OrderVO createOrder(@PathVariable("pid") Integer pid) {
        log.info("商品创建成功，购买的商品{},接下来调用商品微服务查询此商品", pid);
        // 调用商品微服务
        ProductVO productVO = productService.finById(pid);
        OrderVO orderVO = new OrderVO();
        orderService.createOrder(orderVO);
        log.info("创建订单成功，订单信息为{}", JSON.toJSONString(productVO));
        orderVO.setPid(productVO.getPid());
        orderVO.setPname(productVO.getPanme());
        orderVO.setPprice(productVO.getPprice());
        return orderVO;
    }
//    @RequestMapping("/order/prod/{pid}")
//    public OrderVO createOrder(@PathVariable("pid") Integer pid) {
//        log.info("商品创建成功，购买的商品{},接下来调用商品微服务查询此商品", pid);
//        // 调用商品微服务
//        ProductVO productVO = restTemplate.getForObject("http://service-product/product/" + pid,
//                ProductVO.class);
//        OrderVO orderVO = new OrderVO();
////        orderService.createOrder(orderVO);
//        log.info("创建订单成功，订单信息为{}", JSON.toJSONString(productVO));
//        return orderVO;
//    }
}
