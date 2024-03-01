package com.stella.web.orderProduct.service.Impl;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.stella.web.cart.vo.Cart;
import com.stella.web.orderProduct.mapper.OrderProductMapper;
import com.stella.web.orderProduct.service.OrderProductService;
import com.stella.web.orderProduct.vo.OrderProduct;
import com.stella.web.orderProduct.vo.PageBean;


@Service
public class OrderProductServiceImpl implements OrderProductService {
	@Autowired 
	private OrderProductMapper orderProductMapper;
	
	@Override
	public void user(Integer userId,List<Cart>  cartCheckList, Integer totalPrices) {
		orderProductMapper.addOrderProduct(userId,cartCheckList,totalPrices);
		
	}

	@Override
	public PageBean orderProductList(Integer userId, Integer page, Integer pageSize, String begin, String end) {
		PageHelper.startPage(page,pageSize);
		List<OrderProduct> list =orderProductMapper.orderProductList(userId,begin,end);
		 Page<OrderProduct> p = (Page<OrderProduct>)list;
		 PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
		 return pageBean;
	}

	

}
