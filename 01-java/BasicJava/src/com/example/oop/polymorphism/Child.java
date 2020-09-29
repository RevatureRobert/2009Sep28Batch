package com.example.oop.polymorphism;

import com.example.oop.accessmodifiers.FirstHubCap;

public class Child extends Parent {
	
	// An annotation is just metadata that tells the compiler and the developer the purpose of something
	// We can create custom annotations that perform some kind of action
	@Override
	public FirstHubCap attach() {
		return new FirstHubCap();
	}
	
	// Overload
	
	public FirstHubCap attach(String name) {
		return null;
	}
	
	public FirstHubCap attach(int name) {
		return null;
	}
	
	public FirstHubCap attach(String name, int n) {
		return null;
	}
	
	public FirstHubCap attach(int n, String name) {
		return null;
	}

}
