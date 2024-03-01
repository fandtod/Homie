package com.stella.web.orderService.service.Impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.stella.web.orderService.mapper.OrderServiceMapper;
import com.stella.web.orderService.service.OrderServiceService;
import com.stella.web.orderService.vo.OrderService;
import com.stella.web.orderService.vo.PageBean;
import com.stella.web.orderService.vo.YearsBean;

@Service
public class OrderServiceServiceImlp implements OrderServiceService {

	@Autowired
	private OrderServiceMapper orderServiceMapper;

	@Override
	public PageBean page(Integer userId,Integer page, Integer pageSize, String searchPrice1, String searchPrice2,
			String searchText) {
		PageHelper.startPage(page,pageSize);
		List<OrderService> list =orderServiceMapper.memberList(userId,searchPrice1,searchPrice2,searchText);
		 Page<OrderService> p = (Page<OrderService>)list;
		 PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
		 return pageBean;
	}

	@Override
	public YearsBean year(Integer userId) {
		List<Integer> y = orderServiceMapper.charty(userId);
		List<Integer> a = orderServiceMapper.avgprice(userId);
		List<Integer> c = orderServiceMapper.months(userId);
		YearsBean yearsBean = new YearsBean(y,a,c);
		return  yearsBean;
	}
	

}
