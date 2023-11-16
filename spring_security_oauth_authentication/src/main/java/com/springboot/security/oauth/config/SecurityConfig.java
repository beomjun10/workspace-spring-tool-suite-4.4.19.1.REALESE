package com.springboot.security.oauth.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.FilterChainBeanDefinitionParser;
import org.springframework.security.oauth2.client.authentication.OAuth2LoginAuthenticationProvider;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.DefaultSecurityFilterChain;

import com.springboot.security.oauth.auth.FormLoginFailureHandler;
import com.springboot.security.oauth.auth.PrincipalOauth2UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	  
	/*
    1. 애플리케이션을 실행한다.
    2. application-oauth.yml파일을 읽어 OAuth2ClientProperties 생성 한다.
    3. OAuth2ClientPropertiesRegistrationAdapter 를 통해 OAuth2ClientProperties에서
        각 OAuth2 server 마다 ClientRegistration 생성 한다.
    4. ClientRegistration 리스트를 InMemoryClientRegistrationRepository에 저장 한다.
    5. /oauth2/authorization/{registrationId}로 OAuth2 로그인 요청을 한다.
    6. 요청이 오면 OAuth2AuthorizationRequestRedirectFilter에서 registrationId에 따라
      	아이디 / 비밀번호를 입력할 수 있는 uri로 리다이렉트 시킨다.
      	SNS 아이디 / 비밀번호 창에서 로그인 후 Authorization Server에서 등록해 둔 redirect_uri로 인가 코드와 함께 승인이 옴
    7. redirect_uri 즉 /login/oauth2/code/{registrationId}를 OAuth2LoginAuthenticationFilter에서 처리해서 token을 얻어옴
    8. OAuth2LoginAuthenticationProvider를 통해 access token을 이용해서 유저 정보를 얻어온다.
       - 유저 정보 가져오기 OAuth2LoginAuthenticationProvider의 authenticate()메서드 내부에서  access token을 얻은 다음 바로 수행된다.
       - 유저 정보를 바탕으로 회원가입 및 로그인 처리 시도
   			PrincipalOauth2UserService의 loadUser() 메서드를 통해 유저 정보를 얻어온다.    
   */
	@Autowired
    private  PrincipalOauth2UserService principalOauth2UserService;
	@Autowired
    private  FormLoginFailureHandler formLoginFailureHandler;
    private final String[] whitelist = {
            "/resources/**", "/css/**", "/js/**", "/img/**",
            "/oauth2", "/api/**",
            "/",
            "/login", "/join", "/joinOk", "/findPassword", "/findPasswordEmailSend",
            "/item/list", "/item/list/**", "/item/{itemId}"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //post요청 forbiddon에러 방지
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers(whitelist).permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/loginProcessing")
                .defaultSuccessUrl("/dashboard/myInfo")
                .failureHandler(formLoginFailureHandler)
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
            .and()
            .oauth2Login()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard/myInfo")
                .userInfoEndpoint()
                .userService(principalOauth2UserService);
		/*
		http
		        .sessionManagement()
		        .sessionFixation().changeSessionId()
		        .maximumSessions(1)
		        .maxSessionsPreventsLogin(true)
		;
		http.logout()
		        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		        .invalidateHttpSession(true)
		        .clearAuthentication(true)
		        .deleteCookies("JSESSIONID", "remember-me");*/
    }


    
    /*
    @Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<>(new HttpSessionEventPublisher());
    }
    */
}
