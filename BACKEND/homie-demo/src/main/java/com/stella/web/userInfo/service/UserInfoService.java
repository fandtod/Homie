package com.stella.web.userInfo.service;


import java.util.List;

import com.stella.web.cart.vo.Cart;
import com.stella.web.product.vo.Result;
import com.stella.web.userInfo.vo.UserInfo;

public interface UserInfoService {

	UserInfo login(UserInfo user);
	 void registerAccount(UserInfo user);
	 void user(UserInfo userInfo,Integer userId);
	 void users(UserInfo userInfo,Integer userId);
	 List<UserInfo> userAll(Integer userId);
	boolean register(UserInfo user);

}
