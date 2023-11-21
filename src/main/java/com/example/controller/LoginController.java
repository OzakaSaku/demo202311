package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.R;
import com.example.entity.User;
import com.example.filter.LoginCheckFilter;
import com.example.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping({"/" })
    public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.info("重定向到登录");
		
		if (request.getSession().getAttribute("userId") == null) {
			response.sendRedirect(request.getContextPath() + "/login.html");
		} else {
			response.sendRedirect(request.getContextPath() + "/home.html");
		}
        
    }
	
	@PostMapping("/api/login")
    public R<User> login(HttpServletRequest request, @RequestBody User user) {
		log.info("请求/api/login");
		log.info(user.toString());
		
		String userId = user.getUserId();
		String password = user.getPassword();
		
		User u = userService.getById(userId);
        
		if (u == null || !Objects.equals(userId, u.getUserId())) {
			return R.error("社員IDが間違っています。再度入力しなおしてください。");
		}else if (!password.equals(u.getPassword())) {
			return R.error("パスワードが間違っています。再度入力しなおしてください。");
		}
		
		request.getSession().setAttribute("userId", user.getUserId());
		return R.success(user);
    }
	
	@RequestMapping("/api/logout")
    public R<String> logout(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		log.info("请求/api/logout");
		request.getSession().setAttribute("userId", null);
		
		if (request.getSession().getAttribute("userId") == null) {
			return R.success("退出成功");
		} else {
			return R.error("退出失败");
		}
    }
	
	@RequestMapping("/index")
	public String index(Model model, String username) {
		model.addAttribute("msg", "welcome you!" + username);
		return "index";
	}


}
