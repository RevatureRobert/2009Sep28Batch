package com.example.model;

public class Turkey {

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

	@Override
	public String toString() {
		return "Turkey [id=" + id + ", name=" + name + ", beardLength=" + beardLength + ", cooked=" + cooked + "]";
	}

	public Turkey(int id, String name, double beardLength, boolean cooked) {
		super();
		this.id = id;
		this.name = name;
		this.beardLength = beardLength;
		this.cooked = cooked;
	}

	public Turkey() {
		super();
		// TODO Auto-generated constructor stub
	}

}
