package com.stella.web.orderService.service;

import com.stella.web.orderService.vo.PageBean;
import com.stella.web.orderService.vo.YearsBean;

public interface OrderServiceService {
	PageBean page(Integer userId,Integer page,Integer pageSize,String searchPrice1,String searchPrice2,String searchText);

	YearsBean year(Integer userId);
}
