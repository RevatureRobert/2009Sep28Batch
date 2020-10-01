package com.inter.generics;

public class GenericsRunner {

	
	public static void main(String[] args) {
		GenericsExample ge = new GenericsExample();
		ge.setHiddenValue(new Integer(5));
		Integer i = (Integer)ge.getHiddenValue()+5;
		ge.setHiddenValue("|sdoijgh");
		
		
		GenericsExample<Integer> gei = new GenericsExample<>();
		gei.setHiddenValue(8);
		gei.setHiddenValue(gei.getHiddenValue()+10);
		//gei.setHiddenValue("a string somewhere");						// generics provide compile time type checking
	}
}
