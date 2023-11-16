package com.itwill.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.shop.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
