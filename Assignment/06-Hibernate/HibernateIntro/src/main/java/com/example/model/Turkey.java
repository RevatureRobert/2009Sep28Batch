package com.example.model;

public class Turkey {
	
	public Turkey() {
		super();
	}
	public Turkey(String name, double beardLength, boolean cooked) {
		super();
		this.id = 0;
		this.name = name;
		this.beardLength = beardLength;
		this.cooked = cooked;
	}
	public Turkey(int id, String name, double beardLength, boolean cooked) {
		super();
		this.id = id;
		this.name = name;
		this.beardLength = beardLength;
		this.cooked = cooked;
	}
	
	private int id;
	private String name;
	private double beardLength;
	private boolean cooked;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBeardLength() {
		return beardLength;
	}
	public void setBeardLength(double beardLength) {
		this.beardLength = beardLength;
	}
	public boolean isCooked() {
		return cooked;
	}
	public void setCooked(boolean cooked) {
		this.cooked = cooked;
	}
}
