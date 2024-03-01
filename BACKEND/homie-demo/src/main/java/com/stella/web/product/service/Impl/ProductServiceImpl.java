package com.stella.web.product.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.stella.web.product.mapper.ProductMapper;
import com.stella.web.product.service.ProductService;
import com.stella.web.product.vo.PageBean;
import com.stella.web.product.vo.Product;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper productMapper;
	@Override
	public PageBean page(Integer page,Integer pageSize,Integer searchPrice1,Integer searchPrice2,String searchText) {
		 PageHelper.startPage(page,pageSize);
		 List<Product> list =productMapper.list(searchPrice1,searchPrice2,searchText);
		 Page<Product> p = (Page<Product>)list;
		 PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
		 return pageBean;
	}
	@Override
	public List<Product> itemList(Integer id) {
		return productMapper.itemList(id);
	}
}
