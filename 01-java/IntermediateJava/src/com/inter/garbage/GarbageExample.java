package com.inter.garbage;
/*
 * 
 */
public class GarbageExample {
	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = o1;
		o1 = null;
		o2 = null;
		System.gc();
	}
}
