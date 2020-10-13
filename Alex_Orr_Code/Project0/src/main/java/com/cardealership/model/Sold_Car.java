package com.cardealership.model;

public class Sold_Car {
	private int soldCarId;
	private String soldCarName;
	private int ownerUserId;

	public Sold_Car(int sold_car_id, String sold_car_name, int owner_user_id) {
		super();
		this.soldCarId = sold_car_id;
		this.soldCarName = sold_car_name;
		this.ownerUserId = owner_user_id;
	}

	public int getSoldCarId() {
		return soldCarId;
	}

	public String getSoldCarName() {
		return soldCarName;
	}

	public void setSoldCarName(String soldCarName) {
		this.soldCarName = soldCarName;
	}

	public int getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(int ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	@Override
	public String toString() {
		return "Sold_Car [soldCarId=" + soldCarId + ", soldCarName=" + soldCarName + ", ownerUserId=" + ownerUserId
				+ "]";
	}

}
