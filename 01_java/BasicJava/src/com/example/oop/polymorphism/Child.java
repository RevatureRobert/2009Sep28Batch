package com.example.oop.polymorphism;

//import java.io

import com.example.oop.accesscheck.FirstHubCap;
import com.example.oop.encapsulation.EndCap;
/*
 * Polymorphism means many forms and is the ability for the child to change its ability
 * 		from others
 * 
 * 		Compile-Time polymorphism
 * 			method overloading
 * 				3 ways to overload a method
 * 					1. change the type
 * 					2. change the number 
 * 					3. change the order
 * 		Run-Time polymorphism
 * 			method overriding
 * 				certain rules of overriding
 * 					1. cannot reduce the visibility of the method
 * 					2. can change the return type to a covariance of the parent's return type (a subclass)
 * 					3. can change the throws declaration to a subtype of the exception the parent throws 
 */

public class Child extends Parent{
	//overriding
	
	// annotation is just metadata that tells the compiler and the developer the purpose of something
	//		we can create custom annotations that perform some kind of action
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
		
	//change the number of parameters again
	public FirstHubCap attach(String name, int n) {
		return null;
	}	
	
	//change the order of parameters
	public FirstHubCap attach(int n, String name) {
		return null;
	}
}
