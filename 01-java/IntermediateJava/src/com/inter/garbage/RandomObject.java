package com.inter.garbage;

public class RandomObject {

	final private double id = Math.random()*1000; 
		
	
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("the id of this isnstance is :" + this.id);  
	}
}
