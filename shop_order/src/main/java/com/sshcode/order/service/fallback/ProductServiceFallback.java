package com.sshcode.order.service.fallback;

import com.sshcode.model.ProductVO;
import com.sshcode.order.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author sshcode
 * @description 这是一个容错类，需要实现fegin接口，并去实现所有方法，出错后调用此方法
 * @date 2021/8/25 0025
 * 这个方法可以不用，建议用factory
 */
@Service
public class ProductServiceFallback implements ProductService {

    /**
     * 容错逻辑
     * @param pid
     * @return
     */
    @Override
    public ProductVO finById(Integer pid) {
        ProductVO productVO = new ProductVO();
        productVO.setPid(-100);
        productVO.setPanme("调用了容错类");
        return productVO;
    }
}
