package com.friday.java8;

import java.util.Comparator;

/*
 *  FUNCTIONAL INTERFACE
 *  
 *  		can be marked with the functional interface annotation, but not required
 *  		
 *  		a functional interface is an interface with only one method
 */
@FunctionalInterface
public interface Tester {
	
	boolean test();
	
	default boolean test2() { //default was another introduction to java8
		return true;		  //imagine 1000 classes inherit one interface
	}						  //instead of breaking all these classes by changing this interface,
							  //use the default method so that those classes CAN override it, but dont have to use it
}
