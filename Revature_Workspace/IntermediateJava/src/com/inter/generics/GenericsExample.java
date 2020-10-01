package com.inter.generics;

public class GenericsExample<T> {
	
	private T hiddenValue;
	
	public void setHiddenValue(T i) {
		this.hiddenValue = i;
	}
	public T getHiddenValue() {
		return hiddenValue;
	}
}

