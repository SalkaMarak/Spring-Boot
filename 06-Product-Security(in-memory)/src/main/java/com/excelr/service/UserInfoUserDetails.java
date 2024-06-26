package com.excelr.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.excelr.entity.UserInfo;

public class UserInfoUserDetails implements UserDetails
{
	private UserInfo userInfo;
	
	public UserInfoUserDetails(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority(userInfo.getRole());
		return List.of(sga);
	}
	//we have to return a class that extends GrantedAuthority which is sga here in a collection form.

	@Override
	public String getPassword() 
	{
		return userInfo.getPassword();
	}

	@Override
	public String getUsername() 
	{
		return userInfo.getName();
	}

}
