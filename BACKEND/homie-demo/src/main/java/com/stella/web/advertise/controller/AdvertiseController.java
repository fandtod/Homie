package com.stella.web.advertise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stella.web.advertise.service.AdvertiseService;
import com.stella.web.advertise.vo.Advertise;
import com.stella.web.cart.vo.Result;

@RestController
public class AdvertiseController {
	
		@Autowired
		private AdvertiseService advertiseService;

		@GetMapping("/advertise")
		@CrossOrigin(origins = "http://localhost:8080")
		public Result getAdvertise() {
			List<Advertise>  advertiseList  =advertiseService.getAdvertise();
			return Result.success(advertiseList);
		}
	}
