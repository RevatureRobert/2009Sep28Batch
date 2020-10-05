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
 * 		abstract				---------these five (this and above) are the main non access mods
 * 		virtual
 * 		native
 * 		etc.
 */


public final class Modifiers {								//the class cannot be extended if it is final.  This also means the methods will be final.

	
	static String something = "something I don't know";
	String somethingelse = "something else entirely";
	
	final int x = 7;
	final HubCap h = new HubCap(44, "red", "dioshio");		//the field cannot be reassigned.
	
	final String saySomething() {							//the method cannot be overriden if it is final. (Note, you can still overload.  Java treats overloaded methods as completely different methods)
		String some = something;
		String someelse = somethingelse;
//		x++;	//you can't change a final variable
		h.setDiameter(34);  //however, you can change variables ON an object, as long as they aren't final.  We just can't reassign the reference itself.
		return "I have given up";
	}
	
	static String tellSomeone() {
		String some = something;
//		String nono = somethingelse; //Doesn't work, something else is an instance var, can't be accessed in a static way
		
		return "Go and tell them";
	}
}


class example{
	public static void main(String[] args) {
		System.out.println(Modifiers.something);
		Modifiers m = new Modifiers();
		System.out.println(m.something); //Not impossible, but we're accessing a static variable in a nonstatic way.  Probably should not be done.
	}
}