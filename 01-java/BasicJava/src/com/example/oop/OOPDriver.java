package com.example.oop;

import com.example.oop.accessmodifiers.*;
import com.example.oop.encapsulation.*;
import com.example.oop.inheritance.Child;
import com.example.oop.inheritance.Parent;

public class OOPDriver {
	
//	// encapsulation
//	public static void main(String[] args) {
//		HubCap h = new HubCap(17.5, "orange", "badCapShop");
//		com.example.oop.accessmodifiers.FirstHubCap first = new com.example.oop.accessmodifiers.FirstHubCap();
//	}
	
	//inheritance
	public static void main(String[] args) {
//		Parent p = new Parent(35, "Samantha", "Smith", 6.0);
//		System.out.println(p.getHeight());
//		Child c = new Child (12, "Brat", "Danger", 3.0);
//		System.out.println(c.getLastName());
//		Child c2 = new Child();
//		System.out.println(c2.getAge());
		
		// casting
//		Parent casting = new Child();
//		System.out.println(casting.age); // Upcasting. Parent value, because we are using a parent reference
//		System.out.println(((Child)casting).age); // Downcasting. Child value, because we are using a child reference
//		Child badCasting = (Child) new Parent(); // Don't do these
//		System.out.println(badCasting.getAge());
		
//		Parent p = new Child();
//		System.out.println(p.getAge());
//		System.out.println(((Child)p).getAge());
		
		Child c = new Child();
		toString(c);
	}
	
	// Polymorphic parameters: The ability to up-cast to a parent gives us the ability to make a method that
	// takes in a parent or interface and we can use whatever instance we want with it, as long as it inherits
	// from the parent or interface
	public static String toString(Parent p) {
		return p.toString();
	}
	
}