package com.stella.web.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.stella.web.service.vo.Service;

@Mapper
public interface ServiceMapper {
	@Select("SELECT * FROM service")
	public List<Service> list();
}