package com.callawaygolf.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException{

	String message;

	public CustomException(String message) {
		super();
		this.message = message;
	}
	
}
