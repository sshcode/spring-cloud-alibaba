package com.sshcode.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "shop_product")
@Data
public class ProductVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    private String panme;// 商品名称
    private Double pprice;// 价格
    private Integer stock;// 库存
}
