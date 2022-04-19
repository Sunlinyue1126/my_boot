package com.firstdevelop.boot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.firstdevelop.boot.entity.UserEntity;
import com.firstdevelop.boot.mapper.UserMapper;

@Controller
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/user/list")
	public String selectAll(Model model) {
		
		List<UserEntity> list = userMapper.selectAll();
		model.addAttribute("title", "ユーザー一覧");
		model.addAttribute("userList", list);
		return "userList";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/signin")
	public String signin(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession session) {
		UserEntity user = userMapper.login(username,password);
		if(user != null ) {
			session.setAttribute("user",user);
			return "redirect:/order/searchAll";
		}
		
		return "login";
	}
}
