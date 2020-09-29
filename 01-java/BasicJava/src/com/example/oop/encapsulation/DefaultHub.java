package com.example.oop.encapsulation;

public class DefaultHub extends HubCap {
	
	public String getManufacturer() {
		HubCap hc = new HubCap(16.0, "red", "hubsnstuff");
		return hc.manufacturer;
	}

}
