package com.stella.web.advertise.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stella.web.advertise.mapper.AdvertiseMapper;
import com.stella.web.advertise.service.AdvertiseService;
import com.stella.web.advertise.vo.Advertise;

@Service
public class AdvertiseServiceImpl implements AdvertiseService{
	@Autowired
	private AdvertiseMapper advertiseMapper;
	@Override
	public List<Advertise> getAdvertise() {
		return advertiseMapper.getAdvertise();
	}

}
