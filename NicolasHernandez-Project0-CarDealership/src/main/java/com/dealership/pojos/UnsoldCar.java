package com.dealership.pojos;

public class UnsoldCar extends Car {
	private float listPrice;
	
	public UnsoldCar() {
		
	}
	
	public UnsoldCar(int car_id, String color, int year, String make, String model, float listPrice) {
		super(car_id, color, year, make, model);
		this.listPrice = listPrice;
	}
	
	
	
	public float getListPrice() {
		return listPrice;
	}

	public void setListPrice(float listPrice) {
		this.listPrice = listPrice;
	}
}