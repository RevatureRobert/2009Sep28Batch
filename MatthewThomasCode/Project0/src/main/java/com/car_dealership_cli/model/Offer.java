package com.car_dealership_cli.model;

public class Offer {
	private int offerId;
	private Car car;
	private double offer;
	private User user;

	public Offer(int offerId, Car car, double offer, User user) {
		super();
		this.offerId = offerId;
		this.car = car;
		this.offer = offer;
		this.user = user;
	}
	public Offer(Car car, double offer, User user) {
		super();
		this.car = car;
		this.offer = offer;
		this.user = user;
	}
	@Override
	public String toString() {
		return  car + ", Offer $" + offer ;
	}
	public Car getCar() {
		return car;
	}
	public int getOrderId() {
		return offerId;
	}
	public void setOrderId(int orderId) {
		this.offerId = orderId;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public double getOffer() {
		return offer;
	}
	public void setOffer(double offer) {
		this.offer = offer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}

