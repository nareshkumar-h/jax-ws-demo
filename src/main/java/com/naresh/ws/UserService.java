package com.naresh.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.naresh.exception.InvalidLoginException;
import com.naresh.model.User;

@WebService
@SOAPBinding(style = Style.RPC)
public interface UserService {

	@WebMethod(operationName ="login")
	User login(@WebParam(name = "email") String email, @WebParam(name = "password") String password)
			throws InvalidLoginException;

}