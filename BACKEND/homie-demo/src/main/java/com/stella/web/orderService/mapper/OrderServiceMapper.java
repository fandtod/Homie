package com.stella.web.orderService.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.stella.web.orderService.vo.OrderService;
import com.stella.web.product.vo.Product;

@Mapper
public interface OrderServiceMapper {
//	@Select("SELECT * FROM homie.order_service;")
//	public List<OrderService> list();
	
//	@Select("SELECT * FROM order_service WHERE user_id_buyer=#{userId}")
	public List<OrderService> memberList(Integer userId,String searchPrice1,String searchPrice2,String searchText);
	
	
	@Select("select year(order_service_finish_date)FROM order_service WHERE  year(order_service_finish_date)= year(now()) and user_id_buyer=1 and user_id_buyer = #{userId} Group BY year(order_service_finish_date);")
	public List<Integer> charty(Integer userId);

	@Select("select AVG(order_total) FROM order_service WHERE  year(order_service_finish_date)= year(now()) and user_id_buyer = #{userId} Group BY year(order_service_finish_date),month(order_service_finish_date);")
	public List<Integer> avgprice(Integer userId);

	@Select("select month(order_service_finish_date) FROM order_service WHERE  year(order_service_finish_date) = year(now()) and user_id_buyer = #{userId}  Group BY year(order_service_finish_date),month(order_service_finish_date) ORDER BY month(order_service_finish_date);")
	public List<Integer> months(Integer userId);
}
