package com.example.oop.encapsulation;

public class HubCap {
		private double diameter;
		protected String color;
		String manufacturer;
		
		public double getDiameter() {
			return diameter;
		}
		
		public void setDiameter(double diam) {
			if(diam<diameter) {
				diameter = diam;
			}
			
		}
		public HubCap(double diameter, String color, String manufacturer){
			this.diameter = diameter;
			this.color = color;
			this.manufacturer = manufacturer;
		}
}
