package com.stella.web.orderProduct.vo;

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
public class OrderProduct {
	private Integer orderProductId;
	
	private Integer userId;
	
	private Integer productTotal;
	
	private Integer productStatus;
	
	private Integer trackingNumber;
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp deliveryTime;
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp arrivalTime;
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp productPlacementTime;
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp productFinishDate;
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp refundTime;
	
	private String orderProductItem;
	
	private Integer orderProductUnitPrice;
	
	private Integer orderProductQuantity;

	@Override
	public String toString() {
		return "OrderProduct [orderProductId=" + orderProductId + ", userId=" + userId + ", productTotal="
				+ productTotal + ", productStatus=" + productStatus + ", trackingNumber=" + trackingNumber
				+ ", deliveryTime=" + deliveryTime + ", arrivalTime=" + arrivalTime + ", productPlacementTime="
				+ productPlacementTime + ", productFinishDate=" + productFinishDate + ", refundTime=" + refundTime
				+ ", orderProductItem=" + orderProductItem + ", orderProductUnitPrice=" + orderProductUnitPrice
				+ ", orderProductQuantity=" + orderProductQuantity + "]";
	}

	
	
	
	
}
