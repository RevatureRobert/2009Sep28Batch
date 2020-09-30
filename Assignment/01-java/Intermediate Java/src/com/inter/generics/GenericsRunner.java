package com.inter.generics;

public class GenericsRunner {

	public static void main(String[] args) {
		GenericsExample ge = new GenericsExample();
		ge.setHiddenValue(new Integer(5));
		Integer i = (Integer)ge.getHiddenValue()+ 5;
		
		GenericsExample<Integer> gei = new GenericsExample<Integer>(); // don't need this second Integer in the angle brackets
		gei.setHiddenValue(8);
		gei.setHiddenValue(gei.getHiddenValue()+10);
		//gei.setHiddenValeu("sdlflksjdf");			//generics provide compile time type checking
	}

}
