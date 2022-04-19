package com.firstdevelop.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firstdevelop.boot.entity.Product;
import com.firstdevelop.boot.form.ProductForm;
import com.firstdevelop.boot.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/searchAll")
	public String searchAll(Model model) {

		List<Product> productList = productService.searchAll();
		model.addAttribute("productList", productList);
		model.addAttribute("title", "ユーザー一覧");
		
		return "/product/productDetail";
	}
	
	@RequestMapping("/registInit")
	public String registInit() {
		
		return "/product/regist";
	}
	
	@RequestMapping("/regist")
	public String regist(ProductForm form) {
		
		productService.regist(form);
		return "redirect:searchAll";
	}
	
}
