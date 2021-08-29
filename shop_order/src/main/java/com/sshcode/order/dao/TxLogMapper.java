package com.sshcode.order.dao;

import com.sshcode.model.TxLogVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TxLogMapper {

    void save(TxLogVO txLogVO);

    TxLogVO findById(String txId);
}
