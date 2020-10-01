package com.example.oop.encapsulation;

public class HubCap {
	private double diameter;
	protected String color;
	String manufacturer;
	
	public HubCap() {
		diameter = 0;
		color = "red";
		manufacturer = "manu";	
	}
	public HubCap(double diameter, String color, String Manufacturer) {
		this.diameter = diameter;
		this.color = color;
		this.manufacturer = manufacturer;
	}
	
	public double getDiameter() {
		return diameter;
	}
	public void setDiameter(int diameter) {
		if(this.diameter > diameter) {
			this.diameter = diameter;
		}
	}
}
