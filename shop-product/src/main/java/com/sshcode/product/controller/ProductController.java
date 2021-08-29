package com.sshcode.product.controller;


import com.alibaba.fastjson.JSON;
import com.sshcode.model.ProductVO;
import com.sshcode.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     *
     * @return
     */
    @RequestMapping("/product/{pid}")
    public ProductVO findProduct(@PathVariable("pid") Integer pid){
        log.info("开始进行查询 {}号商品信息的查询" , pid);
        ProductVO product = productService.findByPid(pid);
        log.info("商品查询成功,内容为{}", JSON.toJSONString(product));
        return product;
    }
}
