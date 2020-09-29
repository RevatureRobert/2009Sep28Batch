package com.example.oop.accessmodifiers;

import com.example.oop.encapsulation.HubCap;

public class FirstHubCap extends HubCap {
	
	public FirstHubCap() {
		super(15.5, "gray", "hubsrus");
	}
	
	public String getColor() {
		return this.color;
	}
	
	public String getManufacturer() {
		return this.getManufacturer();
	}

}
