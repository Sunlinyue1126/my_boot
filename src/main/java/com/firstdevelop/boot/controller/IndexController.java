package com.firstdevelop.boot.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 接口
 */
@Controller
public class IndexController {

	@RequestMapping(value = {"/", "/index"})
	public String index(Map<String, Object> map) {
		
		map.put("title", "欢迎欢迎，热烈欢迎");
		return "index";
	}
}
