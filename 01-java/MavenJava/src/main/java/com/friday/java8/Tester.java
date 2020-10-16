package com.friday.java8;

/*
 * FUNCTIONAL INTERFACE
 * 
 * 	can be marked with the functional interface annotation, but this is not required
 * 
 * 	a functional interface is an interface with only one method: no more, no less
 */

@FunctionalInterface
public interface Tester {
	boolean test();
	
	default boolean test2() {
		return true;
	}
}
