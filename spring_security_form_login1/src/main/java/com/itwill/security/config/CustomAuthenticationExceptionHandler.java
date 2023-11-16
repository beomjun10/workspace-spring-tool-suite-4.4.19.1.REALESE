package com.itwill.security.config;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itwill.security.controller.ResponseMessage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationExceptionHandler implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
			System.out.println(authException);
		
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setMessage("[commence]인증실패로 AuthenticationException발생");
		//responseMessage.setMessage(authException.getMessage());

		responseMessage.setAuthentication(SecurityContextHolder.getContext().getAuthentication());
		response.setStatus(401);
		response.setContentType("application.json");
		response.setCharacterEncoding("UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		response.getWriter().write(objectMapper.writeValueAsString(responseMessage));
		

	}
	
}
