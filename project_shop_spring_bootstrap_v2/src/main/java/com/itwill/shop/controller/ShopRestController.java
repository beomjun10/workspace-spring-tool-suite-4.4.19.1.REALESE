package com.itwill.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class ShopRestController {
	private String sUserId="guard1";
	@GetMapping("/shop-list-ns")
	public String shop_list_ns(HttpSession session) {
		session.setAttribute("sUserId",sUserId);
		return "{}";
	}
	@GetMapping("/shop-grid-ns")
	public String shop_grid_ns(HttpSession session) {
		session.setAttribute("sUserId",sUserId);
		return "{}";
	}
	@GetMapping("/session-check")
	public ResponseEntity session_check(HttpSession session) throws Exception {
		String sUserId = (String)session.getAttribute("sUserId");
		int status=0;
		if(sUserId!=null) {
			status=1;
		}
		Map resultMap=new HashMap<>();
		resultMap.put("status", status);
		resultMap.put("sUserId", sUserId);
		return ResponseEntity.status(HttpStatus.OK).body(resultMap);
	}
	
}
