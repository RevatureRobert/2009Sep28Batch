package com.dealership.model;

public abstract class User {
	protected final int id;

	User(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
