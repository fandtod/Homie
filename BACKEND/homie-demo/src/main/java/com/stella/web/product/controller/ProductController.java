package com.stella.web.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stella.web.product.service.ProductService;
import com.stella.web.product.vo.PageBean;
import com.stella.web.product.vo.Product;
import com.stella.web.product.vo.Result;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService  productService;
	
	@GetMapping("/searchAll")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result page(@RequestParam(defaultValue = "1")  Integer page,
					   @RequestParam(defaultValue = "8")  Integer pageSize,
					   Integer searchPrice1,
					   Integer searchPrice2,
					   String searchText) {
		PageBean productList =productService.page(page, pageSize,searchPrice1,searchPrice2,searchText);
		return Result.success(productList);
	};
	@GetMapping("/search/{id}")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result itemList(@PathVariable Integer id) {
		List<Product> itemList =productService.itemList(id);
		return Result.success(itemList);
	};
}
