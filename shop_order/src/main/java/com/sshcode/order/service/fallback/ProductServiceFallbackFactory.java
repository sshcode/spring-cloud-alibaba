package com.sshcode.order.service.fallback;

import com.sshcode.model.ProductVO;
import com.sshcode.order.service.ProductService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author sshcode
 * @description 容错类
 * 需要实现一个接口，泛型是调用的哪个接口的容错类
 * @date 2021/8/25 0025
 */
@Slf4j
@Component
public class ProductServiceFallbackFactory implements FallbackFactory<ProductService> {

    /**
     * throwable就是fegin调用过程中产生的异常
     * @param throwable
     * @return
     */
    @Override
    public ProductService create(Throwable throwable) {
        // 匿名内部类
        return new ProductService() {
            @Override
            public ProductVO finById(Integer pid) {
                ProductVO productVO = new ProductVO();
                productVO.setPid(-100);
                productVO.setPanme("调用了容错类");
                return productVO;
            }
        };
    }
}
