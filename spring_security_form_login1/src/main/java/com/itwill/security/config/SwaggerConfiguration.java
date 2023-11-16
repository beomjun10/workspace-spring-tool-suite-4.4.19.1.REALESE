package com.itwill.security.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
public class SwaggerConfiguration {
	/**
	 * Swagger 페이지 접근에 대한 예외 처리
	 *
	 * @param webSecurity
	 */
	public static final String[] SwaggerPatterns = {
		    "/swagger-resources/**",
		    "/swagger-ui/**",
		    "/v3/api-docs/**", 
		    "/v3/api-docs",
		};
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (webSecurity) -> {
			webSecurity.ignoring().requestMatchers(SwaggerPatterns);
			webSecurity.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
		};
	}
}