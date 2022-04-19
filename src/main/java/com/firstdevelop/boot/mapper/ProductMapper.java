package com.firstdevelop.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.firstdevelop.boot.entity.Product;

@Mapper
public interface ProductMapper {

	List<Product> searchAll();
	
	void regist(Product product);
}
