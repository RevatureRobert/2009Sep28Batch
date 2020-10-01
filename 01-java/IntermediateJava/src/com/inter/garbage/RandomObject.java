package com.inter.garbage;

public class RandomObject {
	final private double id = Math.random()*1000;
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("The id of this instance is : " + this.id);
	}
}
