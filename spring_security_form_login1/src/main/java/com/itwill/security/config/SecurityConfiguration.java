package com.itwill.security.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itwill.security.controller.ResponseMessage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity(debug = false)
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration {
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		/*
		 << URL보안 >>
			authenticated()	인증된 사용자의 접근을 허용
			fullyAuthenticated()	인증된 사용자의 접근을 허용, rememberMe 인증 제외
			permitAll()	무조건 접근을 허용
			denyAll()	무조건 접근을 허용하지 않음
			anonymous()	익명사용자의 접근을 허용
			rememberMe()	기억하기를 통해 인증된 사용자의 접근을 허용
			access(String)	주어진 SpEL 표현식의 평가 결과가 true이면 접근을 허용
			hasRole(String)	사용자가 주어진 역할이 있다면 접근을 허용
			hasAuthority(String)	사용자가 주어진 권한이 있다면
			hasAnyRole(String...)	사용자가 주어진 권한이 있다면 접근을 허용
			hasAnyAuthority(String...)	사용자가 주어진 권한 중 어떤 것이라도 있다면 접근을 허용
			hasIpAddress(String)	주어진 IP로부터 요청이 왔다면 접근을 허용
		 */
		/*
		httpSecurity.authorizeHttpRequests(new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
			@Override
			public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry t) {
				t.requestMatchers("/","/authentication").permitAll();
				t.anyRequest().authenticated();
			}
		});
		*/
		httpSecurity.csrf((t) -> {
			t.disable();
			
		});
		httpSecurity.authorizeHttpRequests((t) -> {
			t.requestMatchers("/", "/authentication").permitAll();
			t.anyRequest().authenticated();
			
		});
		httpSecurity.formLogin(Customizer.withDefaults());	
		httpSecurity.formLogin((formLoginConfig)->{
			formLoginConfig.successHandler(new CustomAuthenticationSuccessHandler());
			formLoginConfig.failureHandler(new CustomAuthenticationFailureHandler());
			
		});
	
		httpSecurity.logout((formLogoutConfig)->{
			formLogoutConfig.logoutSuccessHandler(new CustomLogoutHandler());
		});
		
		httpSecurity.sessionManagement((sessionManagementConfig) -> {
			sessionManagementConfig
				.maximumSessions(1)
				.maxSessionsPreventsLogin(true);
		});
		
		httpSecurity.exceptionHandling((exceptionHandlingConfig) -> {
			//exceptionHandlingConfig.authenticationEntryPoint(new CustomAuthenticationExceptionHandler());
			exceptionHandlingConfig.accessDeniedHandler(new CustomAccessDeniedHandler());
			
		});
		
		
		return httpSecurity.build();
	}

	@Bean
	RoleHierarchy roleHierarchy() {
		RoleHierarchyImpl roleHierarchyImpl = new RoleHierarchyImpl();
		roleHierarchyImpl.setHierarchy("ROLE_ADMIN > ROLE_USER");
		return roleHierarchyImpl;
	}

	/*@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	*/
	
	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		UserDetails user2 = User.withUsername("user2").password(passwordEncoder.encode("2222")).roles("USER").build();
		UserDetails admin = User.withUsername("admin").password(passwordEncoder.encode("3333")).roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user2, admin);
	}
	

}
