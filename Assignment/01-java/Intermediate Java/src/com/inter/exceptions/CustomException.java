package com.inter.exceptions;

import java.io.IOException;

public class CustomException extends IOException{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException() {
		super("This is a message from our custom exception");
		// TODO Auto-generated constructor stub
	}

	public CustomException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
}
