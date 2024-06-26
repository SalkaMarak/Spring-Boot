package com.excelr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.excelr.dao.UserRepository;
import com.excelr.entity.UserInfo;

public class UserInfoUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		UserInfo result = userRepo.findByName(username);
		if(result == null) {
			throw new UsernameNotFoundException(username + " user not found.");
		}
		UserInfoUserDetails uiud = new UserInfoUserDetails(result);
		return uiud; 
	}

}
//this layer will interact with the database if the data is valid or nah.

//immediately after the login page is entered this method is called loadUserByUsername and based on the username an object is fetched if not present, exception, if present we pass it to UserInfoUserDetails class where we configure the roles passwords and stuff.