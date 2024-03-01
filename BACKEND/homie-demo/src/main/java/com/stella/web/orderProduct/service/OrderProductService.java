package com.stella.web.orderProduct.service;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.stella.web.cart.vo.Cart;
import com.stella.web.orderProduct.vo.OrderProduct;
import com.stella.web.orderProduct.vo.PageBean;

public interface OrderProductService {

	void user(Integer userId ,List<Cart> cartCheckList,Integer totalPrices);

	PageBean orderProductList(Integer userId,Integer page,Integer pageSize,String begin,String end);

}
