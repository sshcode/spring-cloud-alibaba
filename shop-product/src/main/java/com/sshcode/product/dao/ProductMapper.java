package com.sshcode.product.dao;

import com.sshcode.model.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {

//    @Select("select * from shop_product where pid = #{pid}")
    ProductVO findByPid(Integer pid);
}
