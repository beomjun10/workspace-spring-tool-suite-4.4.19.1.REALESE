package com.itwill.shop.dao;

import java.util.List;

import com.itwill.shop.entity.Cart;

public interface CartDao {

	/*
	 * cart제품 존재여부
	 */
	boolean isProductExist(String sUserId, int p_no) throws Exception;
	boolean isProductExist(Cart cartItem) throws Exception;

	/*
	 * cart insert
	 */
	int addInsert(String sUserId,int p_no,int cart_qty) throws Exception;
	int addInsert(Cart cartItem) throws Exception;
	

	/*
	 * cart add update
	 */
	int addUpdate(String sUserId,int p_no,int cart_qty) throws Exception;
	int addUpdate(Cart cartItem) throws Exception;

	/*
	 * cart update
	 */
	int update(int cart_no, int cart_qty) throws Exception;
	int update(Cart cartItem) throws Exception;

	/*
	 * cart item list
	 */
	List<Cart> getCartList(String sUserId) throws Exception;
	/*
	 * cart item 
	 */
	Cart getCartItemByCartNo(int cart_no) throws Exception;
	/*
	 * cart pk delete
	 */
	int deleteCartByNo(int cart_no) throws Exception;

	/*
	 * cart  delete
	 */
	int deleteCart(String sUserId) throws Exception;

	

}