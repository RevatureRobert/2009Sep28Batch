package com.example.into;

import com.example.oop.encapsulation.EndCap;

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
public final class Modifiers {								// the class cannot be extended, so the methods will also be final

	static String something = "something I dont know";
	String somethingelse = "something else entirely";
	
	final int x = 7;
	final EndCap h = new EndCap(44, "red", "dioshio");		// the field cannot be reassigned
	
	final String saySomething() {							// the method cannot be overridden
		String some = something;
		String someelse = somethingelse;
		return "im gvbing up on you";
		}
	static String tellSomeone() {
		String some = something;
//		String  = somethingelse;		// cannot be done, you cannot access instance fields or methods in a static way
		return "go on and tell them";
	}
}

class example{
	public static void main(String[] args) {
		System.out.println(Modifiers.something);
		Modifiers m = new Modifiers();
		m.
	}
}
