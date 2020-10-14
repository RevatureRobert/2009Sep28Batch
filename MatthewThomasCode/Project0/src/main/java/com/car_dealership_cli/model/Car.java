package com.car_dealership_cli.model;

public class Car {
	private int carId;
	private User owner;
	private String make;
	private String model;
	private int year;
	private double MSRP;
	private double payment;
	private double principle;
	private double debt;
	
	public Car() {
		
	}
	
	public Car(int carId, User owner, String make, String model, int year, double mSRP, double payment,
			double principle, double debt) {
		super();
		this.carId = carId;
		this.owner = owner;
		this.make = make;
		this.model = model;
		this.year = year;
		this.MSRP = mSRP;
		this.payment = payment;
		this.principle = principle;
		this.debt = debt;
	}

	public Car(int carID, String make, String model, int year, double mSRP) {
		super();
		this.carId = carID;
		this.make = make;
		this.model = model;
		this.year = year;
		this.MSRP = mSRP;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return year+", "+ make+", "+model + ", MSRP $" + MSRP;
	}
	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getMSRP() {
		return MSRP;
	}
	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public double getPrinciple() {
		return principle;
	}
	public void setPrinciple(double principle) {
		this.principle = principle;
	}
	public double getDebt() {
		return debt;
	}
	public void setDebt(double debt) {
		this.debt = debt;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	
}
