package com.example.oop.encapsulation;
/*
 * The restriction of direct access to data
 * 
 * we achieve this through access modifiers
 * 
 * the modifiers are:
 * 						anywhere			subclass			packages			same class
 * 		public				x					x					x					x
 * 		protected			0					x					x					x
 * 		default				0					0					x					x
 * 		private				0					0					0					x
 * 
 * Packages and imports
 * 		Packages are how we can organize our classes
 * 		imports are how we can bring classes in other packages into our class
 */
public class EndCap {
	
	private double diameter;
	protected String color;
	String manufacturer;
	
	//getters and setters allow access and mutation of fields
	
	public double getDiameter() {
		return diameter;
	}
	public void setDiameter(double diam) {
		if(diam<diameter) {
			diameter = diam;
		}
		
	}
	
	public EndCap(double diameter, String color, String manufacturer){
		this.diameter=diameter;
		this.color=color;
		this.manufacturer=manufacturer;
	}
	
}
