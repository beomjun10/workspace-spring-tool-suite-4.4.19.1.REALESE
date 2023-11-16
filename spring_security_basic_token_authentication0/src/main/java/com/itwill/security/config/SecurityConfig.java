package com.itwill.security.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig {
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		/*
		 httpSecurity.authorizeHttpRequests((authorizeRequests) ->
		  	authorizeRequests.anyRequest().permitAll() 
		);
		*/
		httpSecurity.csrf((csrf) -> csrf.disable());
		httpSecurity.authorizeHttpRequests((authorizeRequests) -> {
			authorizeRequests.anyRequest().authenticated();
		});
		
		httpSecurity.formLogin((t)->{
			t.disable();
		});
		httpSecurity.httpBasic(Customizer.withDefaults());
		httpSecurity.sessionManagement((sessionManagementConfig)->{
        	// Basic 인증방식으로 세션은 필요 없으므로 비활성화
        	sessionManagementConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });
		return httpSecurity.build();
	}
	
	
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user1 = User.withUsername("user1").password(passwordEncoder().encode("1111")).roles("USER").build();
		return new InMemoryUserDetailsManager(user1);
	}

}
