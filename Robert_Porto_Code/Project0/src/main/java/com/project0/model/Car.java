package com.project0.model;

public class Car {
	private int id;
	private String make;
	private String model;
	private int year;
	private Customer owner;
	private int balance;
	private int price;

	public Car(int id, String make, String model, int year, Customer owner, int balance, int price) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.owner = owner;
		this.balance = balance;
		this.price = price;

	}

	public Car(int id, String make, String model, Integer year, Integer balance, Integer price) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.balance = balance;
		this.price = price;
	}

	public Car(int id, String make, String model, Integer year) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public Car(String make, String model, Integer year, Integer balance, Integer price) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.balance = balance;
		this.price = price;
	}

	public Car(String make, String model, Integer year, Integer price) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.balance = price;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public Customer getOwner() {
		return owner;
	}

	public int getOwnerId() {
		return owner.getId();
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return year + " " + make + model + " " + price + "$";

	}

	public String priceToString() {
		return "Asking: " + price + ":: Current offer: " + balance;
	}

	public int getBalance() {
		return this.balance;
	}

	public int getPrice() {
		return this.price;
	}

	public int getMonthlyPayment() {
		return (this.price / 12);
	}
}
