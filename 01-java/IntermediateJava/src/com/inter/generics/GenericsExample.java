package com.inter.generics;

/*
 * Generics were introduced in Java 5
 * 
 * 
 */

public class GenericsExample <T> {

	private T hiddenvalue;
	
	public static void main(String[] args) {
		GenericsExample ge = new GenericsExample();
		ge.setHiddenValue(5);
		Integer i = (Integer)ge.getHiddenValue() + 5; // !! downcast is an unsafe operation without checking instanceof Integer
		ge.setHiddenValue("r8734g");
		
		GenericsExample<Integer> gei = new GenericsExample<Integer>();
		gei.setHiddenValue(5);
		gei.setHiddenValue(gei.getHiddenValue()+10);
		
	}

	public void setHiddenValue(T i) {
		this.hiddenvalue = i;
	}
	
	public T getHiddenValue() {
		return this.hiddenvalue;
	}
}
