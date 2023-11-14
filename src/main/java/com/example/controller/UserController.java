package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/test")
	public String test() {
		return "hello world!";
	}
	
	@GetMapping("/")
	public List<User> all() {
		List<User> l = userService.list();
		return l;
	}
	
	
}