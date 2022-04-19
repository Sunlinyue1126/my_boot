package com.firstdevelop.boot.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstdevelop.boot.entity.Product;
import com.firstdevelop.boot.form.ProductForm;
import com.firstdevelop.boot.mapper.ProductMapper;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	public List<Product> searchAll() {
		return productMapper.searchAll();
	}
	
	public void regist(ProductForm form) {
		
		Product product = new Product();
		product.setAddress(form.getAddress());
		product.setClassProductId(Integer.parseInt(form.getClassProductId()));
		product.setCreateTime(LocalDateTime.now());
		product.setCreateUser("WEB");
		product.setProductAccount(new BigDecimal(form.getProductAccount()));
		product.setProductDate(LocalDateTime.now());
		product.setProductName(form.getProductName());
		product.setProductPrice(new BigDecimal(form.getProductPrice()));
		product.setUpdateTime(LocalDateTime.now());
		product.setCreateUser("WEB");
		
		productMapper.regist(product);
	}
}
