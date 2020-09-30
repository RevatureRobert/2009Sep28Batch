package com.inter.generics;

public class GenericsRunner {
	
	public static void main(String[] args) {
		GenericsExample<Comparable> ge = new GenericsExample();
		ge.setHiddenValue(new Integer(5));
		Integer i = (Integer)ge.getHiddenValue()+5;
		ge.setHiddenValue("wegweg");
		
		
		GenericsExample<Integer> gei = new GenericsExample<Integer>();
		gei.setHiddenValue(8);
//		gei.setHiddenValue(gei.getHiddenValue()+10);
//		gei.setHiddenValue("a string somewhere"); // generics provide complie time type checking
	}

}
