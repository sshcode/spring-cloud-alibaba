package com.sshcode.order.service;

import com.sshcode.model.ProductVO;
import com.sshcode.order.service.fallback.ProductServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 提供Product  fegin接口
 * fallback 用于指定当前接口容错类
 */
@FeignClient(value ="service-product", /*fallback = ProductServiceFallback.class,*/
fallbackFactory = ProductServiceFallbackFactory.class)
public interface ProductService {

    /**
     * FeginClient的value +@RequestMapping的value值 其实 就是完成的请求地址
     * "http://service-product/product/" + pid,
     * @param pid
     * @return
     */
    @RequestMapping("/product/{pid}") //指定请求的URL
    ProductVO finById(@PathVariable Integer pid);

}
