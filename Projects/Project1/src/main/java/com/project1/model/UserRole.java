package com.project1.model;

public class UserRole {
	private int role;
	
	public UserRole(int role) {
		if(validate(role)) {
			this.role = role;			
		} else {
			throw new IllegalArgumentException(role + " is not a valid user role!");
		}
	}
	
	public int getTypeId() {
		return role;
	}
	
	public boolean setTypeId(int id) {
		if(validate(id)) {
			this.role = id;
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		switch(role) {
		case 1:
			return "Lodging";
		case 2:
			return "Travel";
		default:
			return "Something is wrong with the role";
		}
	}
	
	public boolean validate(int id) {
		return (id > 0 && id < 3); 
	}
}
