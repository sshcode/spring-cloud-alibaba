package com.sshcode.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author sshcode
 * @description 消息事务状态记录
 * @date 2021/8/26 0026
 */
@Entity(name="shop_txlog")
@Data
public class TxLogVO {

    @Id
    private String txId;
    private Date date;
}
