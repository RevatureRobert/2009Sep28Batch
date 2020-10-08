package com.friday.singleton;
/*
 * Sinlgeton Design Pattern
 * 
 * 		The singleton makes a class onlyable to be instantiated once.
 * 			
 * 		Three things you need to make a singleton
 * 			1. private static instance
 * 			2. private constructor
 * 			3. public static getter
 * 
 * */
public class SingletonExample {
	
	volatile private static SingletonExample instance;
	
	
	
	private SingletonExample() {
		
	}
	
	/*synchronized*/ public static SingletonExample getInstance() {
		if(instance == null) {
			instance = new SingletonExample();
		}
		
		return instance;
	}
}
