package com.example.oop.abstraction;

import java.io.Serializable;

/*
 * Interfaces are like contracts with your classes.  When a class
 * 		implements the interface, it must provide functionality
 * 		for any provided methods.
 * 
 * Interfaces have implicit modifiers:
 * 		Methods: public abstract
 * 		Fields(Vars): public static final
 * 
 * Interfaces do not have constructors, and cannot be instantiated
 * 
 * Interfaces are implemented, not extended by classes
 * 		however, interfaces can extend other interfaces.
 * 
 */

public interface Readable extends Serializable{
	
	int age = 5;
	public static String name="";
	public static final String something="";
	
	
	//all three of these methods are viewed as overloading
	//because public and abstract are implicit inside an interface
//	public abstract void read(String book);	
//	public void read();	
//	void read(int pages);
	
}
