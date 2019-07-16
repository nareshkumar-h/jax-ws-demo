package com.naresh.dao;

import com.naresh.model.User;

public class UserDAO {

	public static User login(String email, String password) {
		
		//returning a dummy user object
		User dto = new User();
		dto.setId(1);
		dto.setName("naresh");
		dto.setEmail("naresh@gmail.com");
		dto.setPassword("pass123");
		return dto;
		//throw new InvalidLoginException("Invalid Login Credentials");
		
		
	}
}
