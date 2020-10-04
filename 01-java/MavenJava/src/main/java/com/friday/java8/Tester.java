package com.friday.java8;
/*
 * FUNCTIONAL INTERFACE
 * 
 * 		can be marked with the functional interface annotation, but not required
 * 
 * 		a functional interface is an interface with only one method
 */
@FunctionalInterface
public interface Tester {

	
	boolean test();
	
	default boolean test2() {
		return true;
	}
}
