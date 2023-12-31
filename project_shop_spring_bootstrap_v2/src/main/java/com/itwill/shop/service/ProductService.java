package com.itwill.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itwill.shop.entity.Product;
@Transactional
public interface ProductService {

	/*
	 * DogProduct 리스트반환
	 */
	List<Product> getProductList() throws Exception;

	/*
	 * DogProduct 1개반환
	 */
	Product getProduct(int p_no) throws Exception;

	boolean updateReadcount(int p_no) throws Exception;

}