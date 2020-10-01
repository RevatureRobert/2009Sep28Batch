package com.inter.generics; 
/*
 * generics were introduced in java 5
 * 
 * Gives a way to create an object that holds any type of class, given at instatioation
 */
public class GenericsExample<T> {

	
	private Object hiddenValue;
	
	public void setHiddenValue(Object i) {
		this.hiddenValue = i;
	}
	public Object getHiddenValue() {
		return hiddenValue;
	}
}
