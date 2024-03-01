package com.stella.web.orderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stella.web.orderService.service.OrderServiceService;
import com.stella.web.orderService.vo.Result;
import com.stella.web.orderService.vo.YearsBean;



@RestController
public class ChartController {
	@Autowired
	private OrderServiceService orderServiceService;
	@GetMapping("/year/{userId}")
	@CrossOrigin(origins = "http://localhost:8080")
	   public Result years(@PathVariable Integer userId) {
		   YearsBean yearsBean = orderServiceService.year(userId);
		return Result.success(yearsBean);
		   
	   }
}
