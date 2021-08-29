package com.sshcode.user.dao;


import com.sshcode.model.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserVO findVO(Integer i);
}
