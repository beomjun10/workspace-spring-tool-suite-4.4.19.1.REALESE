package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

	@GetMapping(value = {"/","index"})
	public String index() {
		return "index";
	}
	@GetMapping(value = "/product")
	public String product() {
		return "product";
	}
	
}
