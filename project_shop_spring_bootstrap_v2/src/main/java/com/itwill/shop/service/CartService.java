package com.itwill.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.shop.entity.Cart;
@Transactional(isolation =Isolation.READ_COMMITTED )
public interface CartService {
	/*
	 * 카트추가 or 수정
	 */
	@Transactional(isolation = Isolation.SERIALIZABLE)
	int addCart(String sUserId, int p_no, int cart_qty) throws Exception;
	int addCart(Cart cartItem) throws Exception;
	/*
	 * 카트수량변경수정
	 */
	int updateCart(int cart_no, int cart_qty) throws Exception;
	int updateCart(Cart cartItem) throws Exception;

	/*
	 * 카트보기
	 */
	List<Cart> getCartList(String sUserId) throws Exception;

	/*
	 * 카트아이템1개보기
	 */
	Cart getCartItemByCartNo(int cart_no) throws Exception;

	/*
	 * 카트아이템1개삭제
	 */
	int deleteCartItem(int cart_no) throws Exception;

	/*
	 * 카트삭제
	 */
	int deleteCart(String sUserId) throws Exception;

}