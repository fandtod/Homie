package com.stella.web.cart.service;

import java.util.List;

import com.stella.web.cart.vo.Cart;
import com.stella.web.cart.vo.Result;


public interface CartService {

	void addCart(Cart addcart);
	List<Cart> cartAll(Integer userId);
	void delCart(Integer id,Integer userId);
	void addCartNum(Integer id,Integer userId);
	void subCartNum(Integer id,Integer userId);
	void cartChecked(Integer id,Integer userId);
	List<Cart> cartIdChecked(Integer userId);
	void cartAllChecked(Integer userId);
	void cartDelAllChecked(Integer userId);
	void delCarts(Integer userId,List<Integer> cartdelList);

}
