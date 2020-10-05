package com.example.oop.polymorphism;

import com.example.oop.encapsulation.HubCap;
import com.example.oop.accesscheck.FirstHubCap;

/*
 * Polymorphism, many forms.  The ability for the child to change its ability from others.
 * 
 * 
 * Two types:
 * 		Compile Time Polymorphism
 * 			Method Overloading
 * 				3 Ways to Overload a Method
 * 					1. Change number of parameters
 * 					2. Change type of parameters
 * 					3. Change order of parameters
 * 				You can change the return type as needed, but doesn't cause an overload on it's own.
 * 				You have to do something with the parameters.
 * 
 * 		Runtime Polymorphism
 * 			Method Overriding
 * 				Rules for Overriding
 * 					1. Cannot reduce the visibility of method
 * 					2. Can change return type, but it must be a covariance of the parent's return type (we can return a child, but not a parent)
 * 					3. Can change a throws declaration to a subtype of the parent's throw
 */

public class Child extends Parent{
	
	//overriding
	//annotation: metadata that tells the compiler and developer the purpose of something
	//		we can create custom annotations that perform some kind of action
	//		not necessary, but helpful
	@Override //this tells the compiler that we're trying to override another method, and lets us know if we change something to make it not override
	public FirstHubCap attach() {
		return new FirstHubCap();
	}
	
	//overloading
	
	//change the number of parameters
	public FirstHubCap attach(String name) {
		return null;
	}
	
	//change parameter type
	public FirstHubCap attach(int diameter) {
		return null;
	}
	
	//change number again
	public FirstHubCap attach(String name, int diameter) {
		return null;
	}
	
	//change order of parameters
	public FirstHubCap attach(int diameter, String name) {
		return null;
	}
	
}
