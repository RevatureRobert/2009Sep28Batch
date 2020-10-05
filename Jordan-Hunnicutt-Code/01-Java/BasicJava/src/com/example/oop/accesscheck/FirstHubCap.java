package com.example.oop.accesscheck;

import com.example.oop.encapsulation.HubCap; //have to import the class because in a different package

public class FirstHubCap extends HubCap{

	
	
	public FirstHubCap() {
		super(15.5, "gray", "hubs r us");
	}
	
	public String getColor() {
		return this.color;
		//even though color is protected, since this is a subclass, we can still access it
	}
	
	public String getManufacturer() {
		return this.getManufacturer();
	}
	
}
