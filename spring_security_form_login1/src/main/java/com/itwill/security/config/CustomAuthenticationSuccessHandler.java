package com.itwill.security.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itwill.security.controller.ResponseMessage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationSuccessHandler 
	implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setMessage("[onAuthenticationSuccess]인증성공 Authentication 객체생성");
		responseMessage.setAuthentication(authentication);
		response.setStatus(401);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		response.getWriter().write(objectMapper.writeValueAsString(responseMessage));
		
	}

}
