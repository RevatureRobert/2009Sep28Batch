package com.inter.threads;

public class ThreadExample {
	
	public static void main(String[] args) {
		CustomThread t = new CustomThread();
		CustomThread t2 = new CustomThread();
		System.out.println("t's name is: " + t.getName());
		System.out.println("t2's name is: " + t2.getName());
		System.out.println(t.getState());
		t.start();
		System.out.println(t.getState());
		System.out.println(t.getPriority());
		System.out.println(t.getName());
		System.out.println(t.toString());
		
		
	}
}
