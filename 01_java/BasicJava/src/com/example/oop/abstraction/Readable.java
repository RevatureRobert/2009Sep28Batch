package com.example.oop.abstraction;

/*
 *interfaces are meant to be contracts with your classes. when your
 *		classes implement the interface, it needs to provide the 
 *		functionality for the provided methods
 *
 * interfaces have implicit modifiers
 * 		for methods: public, abstract
 * 		for fields: public, static, final
 * 
 * interfaces do not have constructors and cannot be instatiated
 * 
 * interfaces are implemented, not extended 
 * 		but interfaces can extend one another 
 */

public interface Readable {

	int age = 5;
	public static String name="";
	public static final String something="";
	
	
	public abstract void read(String book);

	public void read();
	
	void read(int pages);
}
