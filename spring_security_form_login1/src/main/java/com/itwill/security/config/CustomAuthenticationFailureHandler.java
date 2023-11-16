package com.itwill.security.config;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itwill.security.controller.ResponseMessage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationFailureHandler 
	implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setMessage("[commence]인증실패로 AuthenticationException발생");
		//responseMessage.setMessage(exception.getMessage());

		responseMessage.setAuthentication(SecurityContextHolder.getContext().getAuthentication());
		response.setStatus(401);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		response.getWriter().write(objectMapper.writeValueAsString(responseMessage));
		
	}
	
}
