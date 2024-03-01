package com.stella.web.orderService.vo;


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
public class OrderService {
	private Integer orderServiceId;
	
	private Integer userIdSeller;
	
	private Integer userIdBuyer;
	
	private Integer orderQuantity;
	
	private Integer orderStatus;
	
	private Integer orderUnitPrice;
	
	private Integer orderTotal;
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp orderPlacementTime;
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp orderServiceFinishDate;
	
	private Integer orderAddGc;
	
	private Integer orderDeductGc;
	
	private Integer orderServiceItem;
	
	private Integer reviewScore;
	
	private String reviewContent;
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp reviewTime;
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp refundTime;

	@Override
	public String toString() {
		return "OrderService [orderServiceId=" + orderServiceId + ", userIdSeller=" + userIdSeller + ", userIdBuyer="
				+ userIdBuyer + ", orderQuantity=" + orderQuantity + ", orderStatus=" + orderStatus
				+ ", orderUnitPrice=" + orderUnitPrice + ", orderTotal=" + orderTotal + ", orderPlacementTime="
				+ orderPlacementTime + ", orderServiceFinishDate=" + orderServiceFinishDate + ", orderAddGc="
				+ orderAddGc + ", orderDeductGc=" + orderDeductGc + ", orderServiceItem=" + orderServiceItem
				+ ", reviewScore=" + reviewScore + ", reviewContent=" + reviewContent + ", reviewTime=" + reviewTime
				+ ", refundTime=" + refundTime + "]";
	}
	
	




	

	
	
	
	
	
}
