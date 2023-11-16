package com.itwill.security.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itwill.security.user.entity.UserDetailsImpl;
import com.itwill.security.user.service.UserDetailsServiceImpl;


@Component
public class DbInit implements InitializingBean {

	@Autowired
	private UserDetailsServiceImpl userService;

	@Override
	public void afterPropertiesSet() throws Exception {
		
		if (userService.findByUserId("user1").isEmpty()) {
			UserDetailsImpl users1 = userService
					.createUser(UserDetailsImpl.builder()
								.userid("user1")
								.password("1111")
								.email("user1@gamil.com")
								.enabled(true)
								.build());
			userService.addAuthority(users1.getUserid(), "ROLE_USER");
			
		}
		
		if (userService.findByUserId("user2").isEmpty()) {
			UserDetailsImpl users2 = userService
					.createUser(UserDetailsImpl.builder()
								.userid("user2")
								.password("2222")
								.email("user2@gamil.com")
								.enabled(true)
								.build());
			
			userService.addAuthority(users2.getUserid(), "ROLE_USER");
		}
		
		
		if (userService.findByUserId("user3").isEmpty()) {
			UserDetailsImpl user3 = userService
					.createUser(UserDetailsImpl.builder()
							.userid("user3")
							.password("3333")
							.email("user3@gmail.com")
							.enabled(true).build());
			userService.addAuthority(user3.getUserid(), "ROLE_ADMIN");
			userService.addAuthority(user3.getUserid(), "ROLE_USER");
		}
		
		
		

	}

}
