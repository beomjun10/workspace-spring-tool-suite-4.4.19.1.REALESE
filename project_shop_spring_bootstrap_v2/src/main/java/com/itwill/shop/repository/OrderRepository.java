package com.itwill.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.shop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
