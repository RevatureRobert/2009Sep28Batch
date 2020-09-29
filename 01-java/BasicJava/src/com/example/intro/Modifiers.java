package com.example.intro;

public class Modifiers {
	
	static String something = "fonwef";
	String somethingelse = "somethingwefnwe else";
	
	static String saySomething() {
		String some = something;
//		String nono = somethingelse; // cannot be done, you can't access instance fields or methods in a static way
		return "go on and tell them";
	}

}
