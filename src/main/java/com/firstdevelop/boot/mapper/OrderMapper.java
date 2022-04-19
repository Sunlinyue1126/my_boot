package com.firstdevelop.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.firstdevelop.boot.entity.Order;
/**
 * 数据层接口
 */
@Mapper
public interface OrderMapper {
	public void insert(
			/**
			 * 注释变量
			 */
		@Param("quantity") int quantity,
		@Param("productID") int productID,
		@Param("userID") Long ID);
	
	public List<Order> searchByUserId(@Param("userID") Long id);
}
