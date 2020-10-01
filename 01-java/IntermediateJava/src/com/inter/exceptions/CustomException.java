package com.inter.exceptions;

import java.io.IOException;

public class CustomException extends IOException {
	
	private static final long serialVersionUID = 1L;
	
	public CustomException() {
		super("This is a method from our custom exception");
	}
	
	public CustomException(String message) {
		super(message);
	}
	
}
