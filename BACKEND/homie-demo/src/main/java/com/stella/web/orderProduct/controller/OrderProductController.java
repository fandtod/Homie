package com.stella.web.orderProduct.controller;



import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stella.web.cart.vo.Cart;
import com.stella.web.orderProduct.service.OrderProductService;
import com.stella.web.orderProduct.vo.OrderProduct;
import com.stella.web.orderService.vo.Result;
import com.stella.web.orderProduct.vo.PageBean;



@RestController
public class OrderProductController {
	@Autowired
	private OrderProductService orderProductService;
	@PutMapping("/orderproduct/{userId}/{totalPrices}")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result user(@PathVariable Integer userId ,@RequestBody List<Cart> cartCheckList,@PathVariable Integer totalPrices) {
		orderProductService.user(userId,cartCheckList,totalPrices);
		return Result.success();		
	}
	
//	@GetMapping("/searchOrderProduct/{userId}")
//	@CrossOrigin(origins = "http://localhost:8080")
//	public Result orderProductList(@PathVariable Integer userId) {
//		List<OrderProduct> itemList =orderProductService.orderProductList(userId);
//		return Result.success(itemList);
//	};
	
	@GetMapping("/searchOrderProduct/{userId}")
	@CrossOrigin(origins = "http://localhost:8080")
	   public Result orderProductList(@PathVariable Integer userId,Integer page,Integer pageSize,		   			
			   	@RequestParam(value = "begin",required = false)String begin,
			   	@RequestParam(value = "end" ,required = false)	String  end) {
		  PageBean pageBean= orderProductService.orderProductList(userId, page, pageSize, begin, end);
		return Result.success(pageBean);
		
	   }
}
