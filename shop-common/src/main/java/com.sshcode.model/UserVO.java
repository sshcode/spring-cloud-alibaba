package com.sshcode.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "shop_user")
@Data
public class UserVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //数据库自增长
    private Integer uid;// 主键
    private String username;// 用户名
    private String password;// 密码
    private String telephone;// 手机
}
