package com.inter.generics;

/*
 * generics were introduced in java 5
 * 
 * replaces Object, acts as a placeholder for any type of variable. 
 * 
 * gives a way to create an object that holds any type of class. The class is given at instantiation. 
 * 
 * since java 7, we can omit the type in the second set of brackets. 
 * 
 */

public class GenericsExample<T> {
	
	private T hiddenValue;
	
	public void setHiddenValue(T i) {
		this.hiddenValue = i;
	}
	
	
	public T getHiddenValue() {
		return hiddenValue;
	}
	

}
