package com.example.oop.polymorphism;

import java.io.IOException;

import com.example.oop.encapsulation.HubCap;

public class Parent {

	HubCap attach() throws IOException{
		return new HubCap(12, "blue","badCaps");
	}
}
