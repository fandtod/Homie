package com.stella.web.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stella.web.cart.service.CartService;
import com.stella.web.cart.vo.Cart;
import com.stella.web.cart.vo.Result;
import com.stella.web.userInfo.vo.UserInfo;

@RestController
public class CartController {
 @Autowired 
 private CartService cartService;
	@PostMapping("/addcart")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result addcart(@RequestBody Cart addcart) {
		cartService.addCart(addcart);
		return Result.success();
		
	}
	
	@GetMapping("/cartall/{userId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public List<Cart> cartAll(@PathVariable Integer userId) {
		List<Cart> cartList =cartService.cartAll(userId);
		return cartList;
		
	}
	
	@DeleteMapping("/cartdel/{id}/{userId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result delcart(@PathVariable Integer id,@PathVariable Integer userId) {
		cartService.delCart(id,userId);
		return Result.success();
		
	}
	@DeleteMapping("/cartdels/{userId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result delcarts(@PathVariable Integer userId,@RequestBody List<Integer> cartdelList) {
		cartService.delCarts(userId,cartdelList);
		return Result.success();
		
	}
	
	@PutMapping("add/{id}/{userId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result add(@PathVariable Integer id,@PathVariable Integer userId) {
		cartService.addCartNum(id,userId);
		return Result.success();
		
	}
	@PutMapping("sub/{id}/{userId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result sub(@PathVariable Integer id,@PathVariable Integer userId) {
		cartService.subCartNum(id,userId);
		return Result.success();
		
	}
	
	@PutMapping("checked/{id}/{userId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result checked(@PathVariable Integer id,@PathVariable Integer userId) {
		cartService.cartChecked(id,userId);
		return Result.success();
		
	}
	
	@GetMapping("/cartchecked/{userId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result cartIdChecked(@PathVariable Integer userId) {
		List<Cart> cartList =cartService.cartIdChecked(userId);
		if(cartList==null) {
			return Result.error("購物車未勾選商品");
		}else {
			return Result.success(cartList);
		}

	}
	
	@PutMapping("cartAllChecked/{userId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result cartAllChecked(@PathVariable Integer userId) {
		cartService.cartAllChecked(userId);
		return Result.success();
		
	}
	
	@PutMapping("cartDelAllChecked/{userId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public Result cartDelAllChecked(@PathVariable Integer userId) {
		cartService.cartDelAllChecked(userId);
		return Result.success();
		
	}
	
}
