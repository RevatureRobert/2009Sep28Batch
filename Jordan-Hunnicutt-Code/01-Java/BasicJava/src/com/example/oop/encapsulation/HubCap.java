package com.example.oop.encapsulation;

/*
 * The restriction of direct access to data
 * 
 * We achieve this through access modifiers
 * 
 * The modifiers are:
 * 						anywhere		subclasses			packages			same class
 * 		public				X				X					X					X
 * 		protected			O				X					X					X
 * 		default (no kw)		O				O					X					X
 * 		private				O				O					O					X
 * 
 * 
 * Packages and imports
 * 		Packages allow us to organize our classes
 * 		imports allow us to bring classes in other packages to our class
 * 
 */


public class HubCap {
	
	//typically, it's safer to make private variables and public getters and setters, that way you can add rules, such as preventing negative values
	private double diameter;
	protected String color;
	String manufacturer;
	
	//getters and setters allow us to access and mutate fields
	//typically set to public
	
	public double getDiameter() { //getters don't get parameters
		return diameter;
		//this allows us to access diameter's value without directly accessing diameter
	}
	
	public void setDiameter(double diam) { //setters get parameters, but don't return anything
		
		if(diam < diameter) {
			diameter=diam;
		}

	}
	
	
	public HubCap(double diameter, String color, String manufacturer){
		
		this.diameter=diameter;
		this.color=color;
		this.manufacturer = manufacturer;
	}
	
	
}
