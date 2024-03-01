package com.stella.web.userInfo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stella.web.product.vo.Result;
import com.stella.web.userInfo.service.UserInfoService;
import com.stella.web.userInfo.vo.UserInfo;

@RestController
public class LoginController {
	@Autowired
	private UserInfoService userInfoService;
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result login(@RequestBody UserInfo user) {
		UserInfo e =userInfoService.login(user);
		return e !=null?Result.success(e):Result.error("用戶名密碼輸入錯誤");
	}
	
	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result register(@RequestBody UserInfo user) {
		boolean a =userInfoService.register(user);
		if(a!=true) {
			return Result.error("已存在");
			
		}else {
			userInfoService.registerAccount(user);		
			return Result.success();
		}
			
	}
	
	
}
