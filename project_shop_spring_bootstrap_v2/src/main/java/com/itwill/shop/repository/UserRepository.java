package com.itwill.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.shop.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
