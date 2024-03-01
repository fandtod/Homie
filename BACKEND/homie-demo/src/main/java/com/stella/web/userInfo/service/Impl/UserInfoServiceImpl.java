package com.stella.web.userInfo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stella.web.product.vo.Result;
import com.stella.web.userInfo.mapper.UserInfoMapper;
import com.stella.web.userInfo.service.UserInfoService;
import com.stella.web.userInfo.vo.UserInfo;
@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Override
	public UserInfo login(UserInfo user) {
		
		return userInfoMapper.getByUseraccountAndUserpassword(user);
	}
	@Override
	public boolean register(UserInfo user) {
		UserInfo i =userInfoMapper.getUseraccoun(user);
		if(i==null) {
			return true;
		}
		return false;
		
    

	}
	@Override
	public void registerAccount(UserInfo user) {
		
		userInfoMapper.insert(user);
	}
	
	
	@Override
	public void user(UserInfo userInfo,Integer userId) {
		userInfoMapper.addUserInfo(userInfo,userId);
	}
	@Override
	public List<UserInfo> userAll(Integer userId) {
		return  userInfoMapper.getUser(userId);
		
	}
	@Override
	public void users(UserInfo userInfo, Integer userId) {
		userInfoMapper.addUserInfos(userInfo,userId);
		
	}


	
	

}
