package com.stella.web.advertise.vo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Advertise {
	private Integer advertiseId;
	
	private Integer serviceId;
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp advertiseStartTime;
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp advertiseEndTime;
	
	private String advertisePictureName;

	@Override
	public String toString() {
		return "Advertise [advertiseId=" + advertiseId + ", serviceId=" + serviceId + ", advertiseStartTime="
				+ advertiseStartTime + ", advertiseEndTime=" + advertiseEndTime + ", advertisePictureName="
				+ advertisePictureName + "]";
	}
	
	
}
