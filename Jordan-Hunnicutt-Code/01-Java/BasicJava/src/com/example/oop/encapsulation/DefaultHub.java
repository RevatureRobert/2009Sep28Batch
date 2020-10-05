package com.example.oop.encapsulation;

public class DefaultHub{

	public String getManufacturer() {
		HubCap h = new HubCap(16.0, "red", "hubsnstuff"); //dont have to import the class because same package
		return h.manufacturer;
	}
	
}
