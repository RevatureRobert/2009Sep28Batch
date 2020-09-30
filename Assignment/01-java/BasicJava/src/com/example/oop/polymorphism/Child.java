package com.example.oop.polymorphism;

import java.io.IOException;

import com.example.oop.accesscheck.FirstHubCap;
import com.example.oop.accesscheck.HubCap;

/*
 * Polymorphism is the ability for the child to change its ability form others
 * 
 * 	Compile Time polymorphism
 * 		method overloading
 * 			3 Ways to overload
 * 				1. change the number of parameters
 * 				2. change the type of parameters
 * 				3. change the order of the parameters
 * 
 * 			you're also allowed to change the return type and access modifier, but that's not overloading.  
 * 	Runtime Polymorphism
 * 		method overriding
 * 			Rules of Overriding
 * 				1. Can't reduce the visibility/accessibility of the method, but you can increase the accessibility
 * 				2. Can change the return type to a covariance of the parent's return type (a subclass)
 * 				3. If parent throws exception, you can throw the same exception or children of that exception
 */
public class Child extends Parent{
	
	//annotation is just metadata that tells the compiler and the developer the purpose of something
	//  we can create custom annotations that perform some kind of action
	
	@Override
	public FirstHubCap attach() {
		return new FirstHubCap();
	}
	
	//overloading
	
	//change the number of parameters
	public FirstHubCap attach(String name) {
		return null;
	}
	//change the type of parameter
	public FirstHubCap attach(int name) {
		return null;
	}
	//change the number again
	public FirstHubCap attach(String name, int age) {
		return null;
	}
	
	//change the order of the parameters
	public FirstHubCap attach(int age, String name) {
		return null;
	}
	

}
