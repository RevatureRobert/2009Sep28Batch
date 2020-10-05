package com.example.intro;

/*
 * access modifiers
 * 		public
 * 		protected
 * 		default (package private)
 * 		private
 * 
 * non-access modifiers
 * 		transient
 * 		synchronized
 * 		static
 * 		final
 * 		abstract
 * 		virtual
 * 		native
 * 		etc. ...
 */

public class Modifiers {
	
	static String something = "accessible without instantiating the class by using Modifiers.something";
	String somethingElse = "accessible only after instantiating an object, then using objectName.somethingElse";

	final int x = 7;
	final String s = "bingo"; // The object CAN be changed, but the reference variable can't be reassigned
	
	public static void main(String[] args) {
		
	}
	
	final String saySomething() {
		String some = something;
		String someElse = somethingElse;
		s.replace('i', 'o');
		return "we need to talk";
	}
	
	String saySomething(String str) { // final methods can be overloaded with non-final methods
		return str;
	}
	
	static String tellSomeone() {
		String some = something;
//		String someElse = somethingElse; // can't be done; you can't access instance fields or methods in a static way
		return "go on and tell them";
	}

}
