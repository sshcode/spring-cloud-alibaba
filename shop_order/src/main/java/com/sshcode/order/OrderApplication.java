package com.sshcode.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author sshcode
 * @description 订单微服务启动类
 * @date 2021/8/23 0023
 */
@SpringBootApplication
@EnableDiscoveryClient //启用nacos
@EnableFeignClients //启用fegin
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }
}
