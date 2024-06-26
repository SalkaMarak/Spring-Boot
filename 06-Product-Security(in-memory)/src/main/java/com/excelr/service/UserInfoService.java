//this is for adding the users
package com.excelr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.excelr.dao.UserRepository;
import com.excelr.entity.UserInfo;

@Service
public class UserInfoService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PasswordEncoder pw;
	
	public String insertUserInfo(UserInfo u) {
		u.setPassword(pw.encode(u.getPassword()));
		userRepo.save(u);
		return "User added successfully to the db";
	}
}
