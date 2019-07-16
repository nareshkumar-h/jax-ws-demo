package com.naresh.exception;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.ws.WebFault;

@WebFault(name="invalidlogin")
@XmlAccessorType( XmlAccessType.FIELD )
public class InvalidLoginException extends RuntimeException {

	private String message;
	public InvalidLoginException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
