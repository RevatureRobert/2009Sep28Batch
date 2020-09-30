package com.example.oop.encapsulation;

/*
 * The restriction of direct access to data
 * 
 * We acheive this through access modifiers
 * 
 * the modifiers are:
 * 
 * 						anywhere		subclasses		package		same class
 * 		public			   X				X				X			X
 * 		protected							X				X			X
 * 		default												X			X
 * 		private															X	
 * 
 * Packages and Imports
 * 		Packages are how we can organize our classes
 * 		imports are how we can bring classes from other packages into our class
 * 
 * 
 */

public class HubCap {
	
	private double diameter;
	
	//getters and setters allow access and mutation of fields
	
	public HubCap(double d, String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public double getDiameter() {
		return diameter;
	}
	
	public void setDiameter(double diam) {
		if(diam<diameter) {
			diameter = diam;
		}
	}

}
