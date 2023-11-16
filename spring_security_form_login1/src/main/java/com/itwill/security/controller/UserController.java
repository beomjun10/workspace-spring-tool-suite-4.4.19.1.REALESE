package com.itwill.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




/*
@PreAuthorize("hasRole('USER')") == @Secured("ROLE_USER")
@PreAuthorize("hasRole('ADMIN') OR hasRole('USER')") == @Secured({"ROLE_USER","ROLE_ADMIN"})
@PreAuthorize("hasAnyAuthority('ROLE_USER')")
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" OR hasAnyAuthority('ROLE_USER')") == @Secured({"ROLE_USER","ROLE_ADMIN"})
*/
@Controller

public class UserController {
	
	/*@PostMapping("/login")
	public String login(@RequestParam(name="username") String username,
						@RequestParam(name="password") String password) {
		return "";
	}*/
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<ResponseMessage> index() {
		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setMessage("메인페이지");
		responseMessage.setAuthentication(SecurityContextHolder.getContext().getAuthentication());
		return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
	}
	
	@GetMapping("/authentication")
	@ResponseBody
	public Authentication authentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	} 
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("/user")
	@ResponseBody
	public ResponseEntity<ResponseMessage> user() {
		ResponseMessage responseMessage=ResponseMessage.builder()
			.message("사용자정보")
			.authentication(SecurityContextHolder.getContext().getAuthentication())
			.build();
		
		return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/admin")
	@ResponseBody
	public ResponseEntity<ResponseMessage> admin() {
		ResponseMessage responseMessage=ResponseMessage.builder()
				.message("관리자정보")
				.authentication(SecurityContextHolder.getContext().getAuthentication())
				.build();
			return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
	}
	
	
}
