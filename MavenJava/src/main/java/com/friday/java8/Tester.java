package com.friday.java8;

@FunctionalInterface
public interface Tester {
	
	boolean test();
	
	default boolean test2() {
		return true;
	}

}
