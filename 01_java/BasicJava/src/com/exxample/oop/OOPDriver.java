package com.exxample.oop;

/*
 *  * brings in all classes inside a package, but not sub packages
 *  you can create naming collisions by importing classes with 
 *  the same name.
 */

import com.example.oop.encapsulation.EndCap;
import com.example.oop.inheritance.Child;
import com.example.oop.inheritance.Parent;
import com.example.oop.accesscheck.*;

public class OOPDriver {
	
	
	public static void main(String[] args) {
		
//		encapsulation
//		EndCap h = new EndCap(17.5, "orange", "badCapShop");
//		//fully qualified name
//		com.example.oop.accesscheck.FirstHubCap first = new com.example.oop.accesscheck.FirstHubCap();
		
		//inheritance
//		parent p = new Parent(35, "Samantha", "Smith", 6.0);
//		System.out.println(p.getHeight);
//		Child c = new Child(12, "Brat", "Danger", 3.0);
//		System.out.println(c.getLastName());
		
//		Casting
//		Parent c = new Child();
//		System.out.println(c.getAge());
//		System.out.println(((Child)c).age); 
//		Child p = (Child) new Parent();
//		System.out.println(p.getAge());
		
//		new Child();
		
		
	}
	
	//polymorphic parameters: the ability to upcast to a parent gives us the ability to make a method that
	//		takes in a parent or interface and we can use whatever instance we want with it, as long as it inherits
	//		from the parent or interface.
	public static String toString(Parent p) {
		return p.toString();
	}

}
