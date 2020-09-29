package com.example.oop.polymorphism;

import com.example.oop.encapsulation.HubCap;

public class Parent {
	
	HubCap attach() {
		return new HubCap(12, "blue", "store");
	}

}
