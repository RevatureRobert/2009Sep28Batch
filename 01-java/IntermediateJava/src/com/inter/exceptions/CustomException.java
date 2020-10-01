package com.inter.exceptions;

import java.io.IOException;

public class CustomException extends IOException {

	private static final long serialVersionUID = 1L;

	public CustomException() {
		super("this is a message from our custom exception");
	}

	public CustomException(String message) {
		super(message);
	}

	
}
