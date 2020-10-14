package com.autos.models;

public class Vehicle {

	private String make;
	private String model;
	private String yr;
	private String msrp;
	private String color;

	public Vehicle () {}

	public Vehicle(String make, String model, String yr, String msrp, String color) {
		this.make = make;
		this.model = model;
		this.yr = yr;
		this.msrp = msrp;
		this.color = color;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getYr() {
		return yr;
	}

	public String getMsrp() {
		return msrp;
	}

	public String getColor() {
		return color;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYr(String yr) {
		this.yr = yr;
	}

	public void setMsrp(String msrp) {
		this.msrp = msrp;
	}

	public void setColor(String color) {
		this.color = color;
	}
}

