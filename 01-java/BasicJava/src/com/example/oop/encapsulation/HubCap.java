package com.example.oop.encapsulation;

/*
 * The restriction of direct access to data
 * 
 * We achieve this through access modifiers
 * 
 * the modifiers are:
 * 						anywhere		subclasses		packages		same class
 * 		public				X				X				X				X
 * 		protected			O				X				X				X
 * 		default				O				O				X				X
 * 		private				O				O				O				X
 * 
 * 
 * Packages and imports
 * 		Packages are how we can organize our classes
 * 		imports are how we can bring classes in other packages into our class 
 */
public class HubCap {

	private double diameter;
	protected String color;
	String manufacturer;

	// getters and setters allow access and mutation of fields

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diam) {
		if (diam < diameter) {
			diameter = diam;
		}
	}
	
	public HubCap(double diameter, String color, String manufacturer){
		this.diameter=diameter;
		this.color=color;
		this.manufacturer=manufacturer;
	}

}
