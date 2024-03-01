package com.stella.web.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import com.stella.web.product.vo.Product;

@Mapper
public interface ProductMapper {

//	@Select("SELECT * FROM product")
	public List<Product> list(Integer searchPrice1,Integer searchPrice2,String searchText);
	
	
	@Select("SELECT * FROM product where product_id=#{id}")
	public List<Product> itemList(Integer id);
}
