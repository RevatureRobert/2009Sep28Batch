package com.example.oop;

import com.example.oop.inheritance.InheritanceChild;
import com.example.oop.inheritance.InheritanceParent;

public class OOPDriver {
	public static void main(String[] args) {
		// encapsulation
		
		// inheritance
//		InheritanceParent p = new InheritanceParent(35, "Samantha", "Smith", 6.0);
//		System.out.println("");
		InheritanceChild c = new InheritanceChild(12, "brat", "danger", 3.0);
		System.out.println(c.getLastName()); // even though InheritanceChild class doesn't define a last name
	}
}
