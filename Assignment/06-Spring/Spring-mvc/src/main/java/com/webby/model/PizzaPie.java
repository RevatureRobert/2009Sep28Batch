package com.webby.model;

import java.util.List;

public class PizzaPie {
	
	private List<String> toppings;
	private String crust;
	private int diameter;
	private boolean stuffed;
	public List<String> getToppings() {
		return toppings;
	}
	public void setToppings(List<String> toppings) {
		this.toppings = toppings;
	}
	public String getCrust() {
		return crust;
	}
	public void setCrust(String crust) {
		this.crust = crust;
	}
	public int getDiameter() {
		return diameter;
	}
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	public boolean isStuffed() {
		return stuffed;
	}
	public void setStuffed(boolean stuffed) {
		this.stuffed = stuffed;
	}
	public PizzaPie(List<String> toppings, String crust, int diameter, boolean stuffed) {
		super();
		this.toppings = toppings;
		this.crust = crust;
		this.diameter = diameter;
		this.stuffed = stuffed;
	}
	public PizzaPie() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PizzaPie [toppings=" + toppings + ", crust=" + crust + ", diameter=" + diameter + ", stuffed=" + stuffed
				+ "]";
	}
	
	

}
