package com.example.oop.polymorphism;

import com.example.oop.accesscheck.FirstHubCap;
import com.example.oop.encapsulation.HubCap;

public class Child extends Parent {
	//annotation is just metadata
	@Override
	public FirstHubCap attach() {
		return new FirstHubCap();
	}
	
	//overloading 
	
	public FirstHubCap attach(String name){
		return null;
		
	}
}
