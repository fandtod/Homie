package com.stella.web.cart.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.stella.web.cart.vo.Cart;
import com.stella.web.cart.vo.Result;



@Mapper
public interface CartMapper {
	@Insert("INSERT INTO cart(user_id,product_id,cart_name,cart_price,cart_num,cart_introduction,cart_picture_name)"
			+ "VALUES(#{userId},#{productId},#{cartName},#{cartPrice},#{cartNum},#{cartIntroduction},#{cartPictureName})")
	void addCart(Cart addcart);
	
	@Select("SELECT count(*) FROM cart where product_id=#{productId} and user_id=#{userId}")
	public Integer productList(Cart addcart);
	
	@Select("SELECT cart_num FROM cart where product_id=#{productId} and user_id=#{userId} ")
	public Integer num(Cart addcart);
	
	@Select("SELECT cart_num FROM cart where product_id=#{id} and user_id=#{userId}")
	public Integer numpid(Integer id,Integer userId);
	
	@Select("SELECT * FROM cart where user_id=#{userId}")
	public List<Cart> cartAll(Integer userId);
	
	@Update("UPDATE cart SET cart_num=#{totalNum} WHERE product_id=#{id} and user_id=#{userId};")
	void addNumCart(Integer id,Integer totalNum,Integer userId);
	
	
	@Update("UPDATE cart SET cart_num=#{totalNum} WHERE product_id=#{addcart.productId} and user_id=#{addcart.userId};")
	void addNum(Integer totalNum,Cart addcart);
	
	@Delete("DELETE FROM cart  WHERE product_id=#{id} and user_id=#{userId};")
	void delcart(Integer id,Integer userId);
	
	@Update("UPDATE cart SET isChecked=1 WHERE product_id=#{id} and user_id=#{userId};")
	void cartChecked(Integer id,Integer userId);
	
	@Update("UPDATE cart SET isChecked=0 WHERE product_id=#{id} and user_id=#{userId};")
	void cartCheckeds(Integer id,Integer userId);
	
	@Select("SELECT isChecked FROM cart where product_id=#{id} and user_id=#{userId}")
	Integer isChecked(Integer id,Integer userId);
	
	@Select("SELECT count(*)FROM cart where isChecked=1 and user_id=#{userId}")
	Integer cartIdChecked(Integer userId);

	@Select("SELECT * FROM cart where isChecked=1 and user_id=#{userId}")
	List<Cart> cartIdCheckedList(Integer userId);

	@Update("UPDATE cart SET isChecked=1 WHERE user_id=#{userId};")
	void cartAllChecked(Integer userId);
	
	@Update("UPDATE cart SET isChecked=0 WHERE user_id=#{userId};")
	void cartDelAllChecked(Integer userId);


	void dels(Integer userId,List<Integer> cartdelList);

}
