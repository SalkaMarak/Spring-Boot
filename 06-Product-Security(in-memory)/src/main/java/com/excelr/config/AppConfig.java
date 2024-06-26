package com.excelr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.excelr.service.UserInfoUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AppConfig {
	
	@Bean	//authentication
	public UserDetailsService userDetServ() { //(PasswordEncoder pw)
		/*UserDetails admin = User.withUsername("admin")
								.password(pw.encode("admin"))
								.roles("ADMIN")
								.build(); 
		UserDetails user = User.withUsername("user")
				.password(pw.encode("user"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(admin, user);*/
		
		return new UserInfoUserDetailsService();
	}
	@Bean	//encripting pw
	public PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider provider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(userDetServ());
		dao.setPasswordEncoder(encode());
		return dao;
	}
	@Bean	//authorization
	public SecurityFilterChain filter(HttpSecurity http) throws Exception{
		return http.csrf().disable()
					.authorizeHttpRequests()
					.requestMatchers("/product/welcome", "/product/new")
					.permitAll()
					.and()
					.authorizeHttpRequests()
					.requestMatchers("/product/all")
					.hasRole("ADMIN")
					.and().authorizeHttpRequests()
					.requestMatchers("/product/**")
					.hasRole("USER")
					//.authenticated() use this when using annotation instead
					.and().formLogin().and().build();
	}
}

//UserDetailsService is interface, implementing class is InMemoryUserDetailsManager
//csrf - cross site request forgery, we use for allowing any frontend application to access our backend application.

//the commented one -this is inmemory 