package com.sshcode.product.service;

import com.sshcode.model.ProductVO;

public interface ProductService {

    /**
     * 根据pid查询vo
     * @param pid
     * @return
     */
    ProductVO findByPid(Integer pid);
}
