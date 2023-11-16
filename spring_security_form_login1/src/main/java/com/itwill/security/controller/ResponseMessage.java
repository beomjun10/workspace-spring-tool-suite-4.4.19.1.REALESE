package com.itwill.security.controller;

import org.springframework.security.core.Authentication;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {
	private String message;
	private Authentication authentication;
}
