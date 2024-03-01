package com.stella.web.advertise.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.stella.web.advertise.vo.Advertise;


@Mapper
public interface AdvertiseMapper {
	@Select("SELECT * FROM advertise ")
	List<Advertise> getAdvertise();
}
