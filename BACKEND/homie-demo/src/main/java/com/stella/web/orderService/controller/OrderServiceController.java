package com.stella.web.orderService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stella.web.orderService.service.OrderServiceService;
import com.stella.web.orderService.vo.OrderService;
import com.stella.web.orderService.vo.PageBean;
import com.stella.web.orderService.vo.Result;


@RestController
public class OrderServiceController {
	@Autowired
	private OrderServiceService orderServiceService;
	
	@GetMapping("/searchmember/{userId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result page(@PathVariable Integer userId,
					   @RequestParam(defaultValue = "1")  Integer page,
					   @RequestParam(defaultValue = "6")  Integer pageSize,
					   String searchPrice1,
					   String searchPrice2,
					   String searchText) {
		PageBean orderServiceList =orderServiceService.page(userId,page, pageSize,searchPrice1,searchPrice2,searchText);
		return Result.success(orderServiceList);
	};
	
}

	