package com.inter.exceptions;

import java.io.IOException;

public class CustomException extends IOException {
	public CustomException() {
		super("this is a message from our custom exception");
	}
	public CustomException(String string) {
		super(string);
	}
}
