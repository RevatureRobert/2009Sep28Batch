package com.example.oop.abstraction;

/*
 * Interfaces are meant to be contracts with your classes. When your classes implement the interface,
 * 		they need to provide the functionality for the required methods.
 * 
 * "public" and "abstract" modifiers are implicitly added to all methods within an interface.
 * 
 * "public" + "static" + "final" modifiers are implicitly added to all fields defined within an interface.
 * 
 * Interfaces have no constructors and cannot be instantiated.
 * 
 * Interfaces are implemented, not extended, by classes.
 * Interfaces can extend other interfaces.
 */

public interface Readable {
	public abstract void read(String book);
//	public void read();
//	void read();
}
