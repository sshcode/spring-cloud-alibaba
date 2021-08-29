package com.sshcode.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "shop_order")
@Data
public class OrderVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    private Integer uid;// 用户id
    private String username;// 用户名
    private Integer pid;// 产品id
    private String pname;
    private Double pprice; //价格
    private Integer number; //购买数量
}
