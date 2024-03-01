package com.stella.web.service.vo;

import java.sql.Timestamp;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Service {
	private Integer serviceId;
	
	private Integer serviceCode;
	
	private Integer userId;
	
	private String serviceName;
	
	private Integer servicePrice;
	
	private String serviceIntroduction;
	
	private byte[] servicePicture;

	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceCode=" + serviceCode + ", userId=" + userId
				+ ", serviceName=" + serviceName + ", servicePrice=" + servicePrice + ", serviceIntroduction="
				+ serviceIntroduction + ", servicePicture=" + Arrays.toString(servicePicture) + "]";
	}

	
	
	
}
