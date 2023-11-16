package com.itwill.shop.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShopController {
	@GetMapping("/sample")
	public String sample(HttpSession session) {
		session.setAttribute("sUserId","guard1");
		return "sample";
	}
	@GetMapping(value = {"/","/index"})
	public String index(HttpSession session) {
		session.setAttribute("sUserId","guard1");
		return "index";
	}
	@GetMapping("/shop-grid-ns")
	public String shop_grid_ns(HttpSession session) {
		session.setAttribute("sUserId","guard1");
		return "shop-grid-ns";
	}
	
}
