package com.sshcode.order.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;

/**
 * @author sshcode
 * @description RestTemplate配置类
 * @date 2021/8/24 0024
 */
@Configuration
public class RestTempConfig {

    @Bean
    @LoadBalanced
    public RestOperations restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
