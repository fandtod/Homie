package com.stella;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.stella.web.service.mapper.ServiceMapper;
import com.stella.web.service.vo.Service;
import com.stella.web.orderService.mapper.OrderServiceMapper;
import com.stella.web.orderService.vo.OrderService;

@SpringBootTest
class HomieDemoApplicationTests {
	@Autowired
	private OrderServiceMapper   orderServiceMapper;
	@Autowired
	private ServiceMapper serviceMapper;
//	@Test
//	void contextLoads() {
//	}
//	@Test
//	public void testListOrderService() {
//		List<OrderService> orderServiceList  = orderServiceMapper.list();
//		orderServiceList.stream().forEach(orderService ->{
//			System.out.println(orderService);
//		});
//	}
//	@Test
//	public void testListService() {
//		List<Service> serviceList = serviceMapper.list();
//		serviceList.stream().forEach(service ->{
//			System.out.println(service);
//		});
//	}

}
