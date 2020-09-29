package com.example.oop.encapsulation;

public class HubCap {
	
	private double diameter;
	protected String color;
	String manufacturer;
	
	// getters and setters allow access and mutation of fields
	
	public double getDiameter() {
		return diameter;
	}
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	
	public HubCap(double dia, String col, String man) {
		diameter = dia;
		color = col;
		manufacturer = man;
	}
	
	public HubCap() {
		
	}
	
}
