package com.example.oop.abstraction;

public interface Readable {
	
	int age = 5;
	public static String name="";
	public static final String something="asd";

	public abstract void read(String book);
	
	public void read();
	
	void read(int pages);
	
}
