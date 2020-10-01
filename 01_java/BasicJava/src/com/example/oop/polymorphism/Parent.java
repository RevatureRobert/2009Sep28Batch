package com.example.oop.polymorphism;

import com.example.oop.encapsulation.EndCap;

public class Parent {
	EndCap attach() {
		return new EndCap(12, "blue", "someBrand");
	}

}
