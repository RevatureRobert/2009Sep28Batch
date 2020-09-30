package com.example.oop.abstraction;


/*
 * 
 * interfaces are meant to be contracts with your classes. when your
 * 		classes implement the interface, it needs to provide the 
 * 		functionality for the provided methods.
 * 
 * interfaces have implicit modifiers:
 * 			for methods: public abstract
 * 			for variables: 
 * 
 * interfaces don't have constructors and cannot be instantiated
 * 
 * interfaces are implemented, not extended by classes
 * 		however interfaces can extend other interfaces
 */
public interface Readable {
	
	int age = 5;
	
	public static String name = "";
	//public static final String 
	
	public abstract void read(String book);
	
	public void read();
	
	void read(int pages);
}
