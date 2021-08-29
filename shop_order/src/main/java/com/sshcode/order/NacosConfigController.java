package com.sshcode.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sshcode
 * @description nacos config控制类
 * @date 2021/8/26 0026
 */
@RestController
@RefreshScope // 让value生效
public class NacosConfigController {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Value("${config.appName}")
    private String appName;

    @Value("${config.env}")
    private String env;
    /**
     * 如何从nacos中获取配置
     * @return
     */
    @RequestMapping("/test-config1")
    public String testConfig1(){
        return applicationContext.getEnvironment().getProperty("config.appName");
    }

    @RequestMapping("/test-config2")
    public String testConfig2(){
        return appName;
    }

    @RequestMapping("/test-config3")
    public String testConfig3(){
        return env;
    }
}
