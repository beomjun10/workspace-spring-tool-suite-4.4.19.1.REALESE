package com.itwill.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.shop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
