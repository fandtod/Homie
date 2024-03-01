package com.stella.web.product.vo;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private Integer productId;
	
	private String productName;
	
	private Integer productPrice;
	
	private Integer productStock;
	
	private Integer productShipped;
	
	private String  productIntroduction;
	
	private byte[]  productPicture;
	
	private String  productPictureName;


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productStock=" + productStock + ", productShipped=" + productShipped + ", productIntroduction="
				+ productIntroduction + ", productPicture=" + Arrays.toString(productPicture) + ", productPictureName="
				+ productPictureName + "]";
	}

	

	
	
	
}
