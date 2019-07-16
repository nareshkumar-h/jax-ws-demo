package com.naresh;

import javax.xml.ws.Endpoint;

import com.naresh.ws.UserService;
import com.naresh.ws.UserServiceImpl;

public class APIPublisher {

	public static void main(String[] args) {
		
		UserService userService = new UserServiceImpl();
		Endpoint.publish("http://localhost:8090/users", userService);
	}

}
