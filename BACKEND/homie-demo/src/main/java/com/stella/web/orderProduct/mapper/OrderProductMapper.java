package com.stella.web.orderProduct.mapper;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.stella.web.cart.vo.Cart;
import com.stella.web.orderProduct.vo.OrderProduct;

@Mapper
public interface OrderProductMapper {
//	@Insert("INSERT INTO order_product(user_id,product_total,product_status,product_placement_time)VALUES(#{userId},#{userInfo.totalPrice},1,#{userInfo.nowDate})")
	void addOrderProduct(Integer userId,List<Cart> cartCheckList, Integer totalPrices);
	
//	@Select("SELECT * FROM order_product where user_id=#{userId} and product_placement_time <= #{begin} and product_placement_time<=#{end}")
	List<OrderProduct> orderProductList(Integer userId, String begin, String end);
		
}
