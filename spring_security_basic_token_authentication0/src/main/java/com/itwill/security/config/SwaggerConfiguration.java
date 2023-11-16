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
@SecurityScheme(
        name = "basicAuth", // can be set to anything
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
@OpenAPIDefinition(
        info = @Info(title = "Sample API", version = "v1"),
        security = @SecurityRequirement(name = "basicAuth") // references the name defined in the line 3 
)
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