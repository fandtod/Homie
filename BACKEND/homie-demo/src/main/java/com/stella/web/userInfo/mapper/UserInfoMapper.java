package com.stella.web.userInfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.stella.web.userInfo.vo.UserInfo;

@Mapper
public interface UserInfoMapper {
	@Select("SELECT * FROM user_info WHERE user_account=#{userAccount} and user_password=#{userPassword}")
	UserInfo getByUseraccountAndUserpassword(UserInfo user);
	
	@Insert("INSERT INTO user_info(user_account,user_password)VALUES(#{userAccount},#{userPassword});")
	void insert(UserInfo user);
	
	@Select("SELECT * FROM user_info WHERE user_account=#{userAccount}")
	UserInfo getUseraccoun(UserInfo user);
	
	@Select("SELECT * FROM user_info WHERE user_id=#{userId}")
	List<UserInfo> getUser(Integer userId);
	
	@Update("UPDATE user_info SET user_name=#{userInfo.userName},garbage_coin=#{userInfo.garbageCoin},user_phone=#{userInfo.userPhone},user_address=#{userInfo.userAddress},user_ic=#{userInfo.userIc} WHERE  user_id=#{userId};")
	void addUserInfo(UserInfo userInfo,Integer userId);
	
	@Update("UPDATE user_info SET user_name=#{userInfo.userName},user_phone=#{userInfo.userPhone},user_address=#{userInfo.userAddress} WHERE  user_id=#{userId};")
	void addUserInfos(UserInfo userInfo,Integer userId);
	







}
