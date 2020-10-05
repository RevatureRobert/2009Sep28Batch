package com.inter.generics;
/*
 * 
 * Generics were introduced in java 5
 * 
 * Gives a way to create an object that holds any type of class, given at instantiation.
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
