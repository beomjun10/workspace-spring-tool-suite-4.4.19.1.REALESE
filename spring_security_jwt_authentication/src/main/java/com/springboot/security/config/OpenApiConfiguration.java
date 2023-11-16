package com.springboot.security.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Product Open Api"))
@SecurityScheme(name = "BearerAuth",
			type = SecuritySchemeType.HTTP, 
			scheme = "bearer",
			bearerFormat = "JWT")
public class OpenApiConfiguration {
	/*
	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("public") // 그룹 이름
				.pathsToMatch("/**") // API 경로 패턴
				.build();
	}

  

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.security(null)
				.components(new Components())
				.info(new Info().title("Your API")
				.version("1.0"))
				.addSecurityItem(new SecurityRequirement().addList("JWT"));
	}
	*/
}
