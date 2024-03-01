package com.stella.web.product.service;

import java.util.List;

import com.stella.web.product.vo.PageBean;
import com.stella.web.product.vo.Product;

public interface ProductService {
	PageBean page(Integer page,Integer pageSize,Integer searchPrice1,Integer searchPrice2,String searchText);
	List<Product> itemList(Integer id);
}
