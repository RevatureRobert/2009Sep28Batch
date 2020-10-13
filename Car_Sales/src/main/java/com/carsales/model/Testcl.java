package com.carsales.model;

public class Testcl {
	public int id;
	public String stringtest;
	public boolean hasfun;
	
	public Testcl(int i, String s, boolean h) {
		id = i;
		stringtest = s;
		hasfun = h;
		
	}
	
	public String print()
	{
		return stringtest + " " + id + " " + hasfun;
	}

}
