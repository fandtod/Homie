package com.stella.web.userInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stella.web.product.vo.Result;
import com.stella.web.userInfo.service.UserInfoService;
import com.stella.web.userInfo.vo.UserInfo;

@RestController
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	@PutMapping("/information/{userId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result user(@PathVariable Integer userId ,@RequestBody UserInfo userInfo) {
		userInfoService.user(userInfo,userId);
		return Result.success();		
	}
	
	@PutMapping("/informations/{userId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result users(@PathVariable Integer userId ,@RequestBody UserInfo userInfo) {
		userInfoService.users(userInfo,userId);
		return Result.success();		
	}
	
	@GetMapping("/userall/{userId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public List<UserInfo> userall(@PathVariable Integer userId) {
		 List<UserInfo> userList=userInfoService.userAll(userId);
		return userList;		
	}
	
}
