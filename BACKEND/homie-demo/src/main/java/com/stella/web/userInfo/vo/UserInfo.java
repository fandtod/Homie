package com.stella.web.userInfo.vo;

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
public class UserInfo {
	private Integer userId;
	
	private String userAccount;
	
	private String userPassword;
	
	private String userName;
	
	private String userAddress;
	
	private String userPhone;
	
	private Integer userGender;
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp userBirth;
	
	private String userIc;
	
	private byte[] userPic;
	
	private Integer userStatus;
	
	private Integer userCoin;
	
	private Integer userIdentity;
	
	private Integer garbageCoin;

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userAccount=" + userAccount + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", userAddress=" + userAddress + ", userPhone=" + userPhone
				+ ", userGender=" + userGender + ", userBirth=" + userBirth + ", userIc=" + userIc + ", userPic="
				+ Arrays.toString(userPic) + ", userStatus=" + userStatus + ", userCoin=" + userCoin + ", userIdentity="
				+ userIdentity + ", garbageCoin=" + garbageCoin + "]";
	}

	
	
	
	
	
}
