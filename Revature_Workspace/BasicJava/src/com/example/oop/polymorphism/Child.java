package com.example.oop.polymorphism;

import com.example.oop.encapsulation.FirstHubCap;
import com.example.oop.encapsulation.HubCap;

public class Child extends Parent{
	@Override
	public FirstHubCap attach() {
		return FirstHubCap();
	}
	
	//overloading
	
	private FirstHubCap FirstHubCap() {
		// TODO Auto-generated method stub
		return null;
	}

	//change the number of parameters
	public FirstHubCap attach(String name) {
		return null;
	}
	
	//change the type of the parameter
	public FirstHubCap attach(int name) {
		return null;
	}
	public FirstHubCap attach(int name, String name1) {
		return null;
	}
}
