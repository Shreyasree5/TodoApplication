package com.webApplication.TodoList.security;


import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
    @Bean
	public InMemoryUserDetailsManager createUserDetailsManage() {
    	
		Function<String, String> passwordEncoder 
	     = input -> passwordEncoder().encode(input);
	
		UserDetails us = User.builder()
				.passwordEncoder(passwordEncoder)
				.username("Shreya")
				.password("neethu")
				.roles("USER", "ADMIN")
				.build();
		return new InMemoryUserDetailsManager(us);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
