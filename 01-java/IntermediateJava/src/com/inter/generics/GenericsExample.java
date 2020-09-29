package com.inter.generics;

// generics were introduced in java 5

public class GenericsExample<T> {
	
	private T hiddenValue;
	
	public void setHiddenValue(T i) {
		this.hiddenValue = i;
	}
	
	public Object getHiddenValue() {
		return hiddenValue;
	}

}
