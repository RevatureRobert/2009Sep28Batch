package com.friday.Java8;

/*
 * FUCNTIONAL INTERFACE
 * 
 * 	can be marked with the functional interface annotation, but not required
 * 
 * functional interfaces only have one method, marking interfaces have no methods. 
 */

@FunctionalInterface
public interface Tester {
	
	boolean test();
	
	default boolean test2() {
		return true;
	}

}
