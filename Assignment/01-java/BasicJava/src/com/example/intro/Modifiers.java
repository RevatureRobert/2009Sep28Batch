package com.example.intro;

import com.example.oop.encapsulation.HubCap;

/*
 * access modifiers
 * 		public
 * 		protected
 * 		default (package private)
 * 		private
 * 
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
public final class Modifiers {    // the class cannot be extended, so methods will also be final
	
	static String something = "something I don't know";
	String somethingelse = "something else";
	
	final int x = 7;
	final HubCap h = new HubCap(44,"red", "didid"); // the variable h cannot be reassigned
	
	String saySomething() {
		String some = something;
		String someelse = somethingelse;
		return "im giving up on you";
	}
	
	final String tellSomeone() { // the method cannot be overridden. 
		String some = something;
		//String nana = somethingelse; can't do this because it's for the class, not the instance. 
		return "go on and get";
	}

}

class example{
	public static void main(String[] args) {
		System.out.println(Modifiers.something);
		Modifiers m = new Modifiers();
		System.out.println(m.somethingelse);
		
	}
}
