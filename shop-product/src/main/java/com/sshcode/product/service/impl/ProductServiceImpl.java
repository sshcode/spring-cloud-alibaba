package com.sshcode.product.service.impl;

import com.sshcode.model.ProductVO;
import com.sshcode.product.dao.ProductMapper;
import com.sshcode.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductVO findByPid(Integer pid) {
        return productMapper.findByPid(pid);
    }
}
