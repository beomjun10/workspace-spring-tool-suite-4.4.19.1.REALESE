package com.itwill.security.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = false)
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = false)
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		/*
		 * http.authorizeHttpRequests((authorizeRequests) ->
		 * authorizeRequests.anyRequest().permitAll() );
		 */

		http.authorizeHttpRequests((authorizeRequests) -> {
			authorizeRequests.requestMatchers("/","/index","/login-form","/authentication","/login-error").permitAll();
			authorizeRequests.anyRequest().authenticated();
		});
		/*
		 * spring security form login을 사용
		 */
		http.formLogin(Customizer.withDefaults());	
		http.formLogin((formLoginConfig)->{
			formLoginConfig.loginPage("/login-form")
						   .loginProcessingUrl("/login")
						   .defaultSuccessUrl("/",true)
						   .failureUrl("/login-error");
						  
		});
		http.logout((formLogoutConfig)->{
			formLogoutConfig.logoutUrl("/logout");
			formLogoutConfig.logoutSuccessUrl("/");
		});
		http.exceptionHandling((exceptionHandlingConfig)->{
			exceptionHandlingConfig.accessDeniedPage("/access-denied");
		});
		http.sessionManagement((t)->{
			t.maximumSessions(1).maxSessionsPreventsLogin(true);
		});
		return http.build();
	}

	@Bean
	RoleHierarchy roleHierarchy() {
		RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
		roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");
		return roleHierarchy;
	}

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withUsername("user2").password(passwordEncoder().encode("2222")).roles("USER").build();
		UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("3333")).roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user, admin);
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {

		return (webSecurityBuilder) -> {
			webSecurityBuilder.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
		};
	}

}
