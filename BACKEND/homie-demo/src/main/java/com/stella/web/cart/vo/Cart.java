package com.stella.web.cart.vo;

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
public class Cart {
	
	private Integer userId;
	
	private Integer productId;
	
	private String 	cartName;
	
	private Integer cartPrice;
	
	private Integer cartNum;
	
	private String 	cartIntroduction;
	
	private byte[]  cartPicture;
	
	private boolean isChecked;
	
	private String 	cartPictureName;

	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", productId=" + productId + ", cartName=" + cartName + ", cartPrice="
				+ cartPrice + ", cartNum=" + cartNum + ", cartIntroduction=" + cartIntroduction + ", cartPicture="
				+ Arrays.toString(cartPicture) + ", isChecked=" + isChecked + ", cartPictureName=" + cartPictureName
				+ "]";
	}

	
	





	
	
}


