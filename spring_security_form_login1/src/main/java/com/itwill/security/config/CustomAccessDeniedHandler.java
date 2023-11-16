package com.itwill.security.config;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itwill.security.controller.ResponseMessage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setMessage("[handle]인가실패로 AccessDeniedException발생");
		responseMessage.setMessage(accessDeniedException.getMessage());

		responseMessage.setAuthentication(SecurityContextHolder.getContext().getAuthentication());
		response.setStatus(403);
		response.setContentType("application.json");
		response.setCharacterEncoding("UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		response.getWriter().write(objectMapper.writeValueAsString(responseMessage));
		
	}

}
