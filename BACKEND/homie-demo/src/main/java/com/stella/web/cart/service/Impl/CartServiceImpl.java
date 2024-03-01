package com.stella.web.cart.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stella.web.cart.mapper.CartMapper;
import com.stella.web.cart.service.CartService;
import com.stella.web.cart.vo.Cart;
import com.stella.web.cart.vo.Result;




@Service
public class CartServiceImpl implements CartService {
	@Autowired 
	private CartMapper cartMapper;
	@Override
	public void addCart(Cart addcart) {
		Integer id =cartMapper.productList(addcart);
		if(id==0) {
			cartMapper.addCart(addcart);
			
		}else {
			 Integer num =cartMapper.num(addcart);
			 Integer totalNum = num+ addcart.getCartNum();
			cartMapper.addNum(totalNum,addcart);
			}
		
	}
	@Override
	public List<Cart> cartAll(Integer userId) {
		return cartMapper.cartAll(userId);
	}
	@Override
	public void delCart(Integer id,Integer userId) {
		cartMapper.delcart(id,userId);
		
	}
	@Override
	public void addCartNum(Integer id,Integer userId) {
		Integer num =cartMapper.numpid(id,userId);
		Integer totalNum=num+1;
		cartMapper.addNumCart(id, totalNum,userId);
		
	
		
	}
	@Override
	public void subCartNum(Integer id, Integer userId) {
		Integer num =cartMapper.numpid(id,userId);
		if(num==1) {
			cartMapper.delcart(id,userId);
		}else {
			num--;
			cartMapper.addNumCart(id, num,userId);	
		}
		
	}
	@Override
	public void cartChecked(Integer id,Integer userId) {	
		Integer a =cartMapper.isChecked(id, userId);
			if(a==0) {
				cartMapper.cartChecked(id, userId);
				return;
			}
			if(a==1) {
				cartMapper.cartCheckeds(id, userId);
				return;
			}	
			
				
		
		
	}
	@Override
	public List<Cart> cartIdChecked(Integer userId) {
		Integer n =cartMapper.cartIdChecked(userId);
		if(n==0) {
			return null;
		}else {
			return cartMapper.cartIdCheckedList(userId);
		}
		
	}
	@Override
	public void cartAllChecked(Integer userId) {
		 cartMapper.cartAllChecked(userId);
	}
	@Override
	public void cartDelAllChecked(Integer userId) {
		cartMapper.cartDelAllChecked(userId);
	}
	@Override
	public void delCarts(Integer userId,List<Integer> cartdelList) {
		cartMapper.dels(userId,cartdelList);
		
	}
	

}
