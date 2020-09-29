package com.example.intro;

import com.example.oop.encapsulation.HubCap;

/*
 * access modifiers
 * 		public
 * 		protected
 * 		default (package private)
 * 		private
 * 
 * non access modifiers
 * 		transient
 * 		synchronized
 * 		static
 * 		final
 * 		abstract
 * 		virtual
 * 		native
 * 		etc.
 */
public final class Modifiers {									// the class cannot be extended, so the methods will also be final
	
	static String something = "something i dont know";
	String somethingelse = "something else entierly";
	
	final int x = 7;
	final HubCap h = new HubCap(44,  "red", "dioshio");			// the field cannot be reassigned
	
	final String saySomething() {								// the method cannot be overridden
		String some = something;
		String someelse = somethingelse;
		h.setDiameter(34);
		return "im giving up on you";
	}
	
	String saySomething(String s) {
		return s;
	}
	
	static String tellSomeone() {
		String some = something;
//		String nono = somethingelse;		// cannot be done, you cant access instance fields or methods in a static way
		return "go on and tell them";
	}
	
	
}


class example{
	public static void main(String[] args) {
		System.out.println(Modifiers.something);
		Modifiers m = new Modifiers();
		System.out.println(m.something);
	}
}