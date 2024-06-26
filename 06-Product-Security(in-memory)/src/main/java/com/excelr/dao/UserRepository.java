package com.excelr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {

	public UserInfo findByName(String name); 
}


//spring boot will implement the method
//@Query("select name from userInfo") internally