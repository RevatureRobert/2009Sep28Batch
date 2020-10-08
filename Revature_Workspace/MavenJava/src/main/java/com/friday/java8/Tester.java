package com.friday.java8;

/*
 * Functional Interface
 * 		can be marked with the functional interface annotation, but not required.
 *		A functional interface is an interface with only 1 method
 *
 *		
 * */
@FunctionalInterface
public interface Tester {
	boolean test();
	
	default boolean test2() {
		return true;
	}
}
