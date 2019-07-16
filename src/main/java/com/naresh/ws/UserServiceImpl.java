package com.naresh.ws;

import javax.jws.WebService;

import com.naresh.dao.UserDAO;
import com.naresh.exception.InvalidLoginException;
import com.naresh.model.User;
@WebService(endpointInterface = "com.naresh.ws.UserService")
public class UserServiceImpl implements UserService {	
	
	 public User login(String email,String password) throws InvalidLoginException{
		System.out.println("UserService -> login - email:" + email + ",password:" + password);
		 return UserDAO.login(email, password);
	 }
}
