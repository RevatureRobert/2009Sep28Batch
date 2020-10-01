package com.example.oop;

import com.example.oop.inheritance.*;

public class OOPDriver {
	public static void main(String[] args) {
		Parent p = new Parent("Alex", 35, "Orr", 6.0);
		System.out.println(p.getHeight());
		
//		Child c = new Child(12, "Danger", "Kid", 2.0);
		Parent c = new Child();
//		System.out.println(c.age); // parents value, because we are using a prent reference (up casting)
//		System.out.println(((Child)c).age); // childs value, because we are using the child reference (down casting)
	}
}
