package com.cardealership.model;

public class Unsold_Car {
	private int unsoldCarId;
	private String unsoldCarName;
	private int unsoldCarAskingPrice;
	private int unsoldCarDealershipId;
	public Unsold_Car(int unsoldCarId, String unsoldCarName, int unsoldCarAskingPrice, int unsoldCarDealershipId) {
		super();
		this.unsoldCarId = unsoldCarId;
		this.unsoldCarName = unsoldCarName;
		this.unsoldCarAskingPrice = unsoldCarAskingPrice;
		this.unsoldCarDealershipId = unsoldCarDealershipId;
	}
	public int getUnsoldCarId() {
		return unsoldCarId;
	}
	public String getUnsoldCarName() {
		return unsoldCarName;
	}
	@Override
	public String toString() {
		return "Unsold_Car [unsoldCarId=" + unsoldCarId + ", unsoldCarName=" + unsoldCarName + ", unsoldCarAskingPrice="
				+ unsoldCarAskingPrice + ", unsoldCarDealershipId=" + unsoldCarDealershipId +  "]";
	}
	public void setUnsoldCarName(String unsoldCarName) {
		this.unsoldCarName = unsoldCarName;
	}
	public int getUnsoldCarAskingPrice() {
		return unsoldCarAskingPrice;
	}
	public void setUnsoldCarAskingPrice(int unsoldCarAskingPrice) {
		this.unsoldCarAskingPrice = unsoldCarAskingPrice;
	}
	public int getUnsoldCarDealershipId() {
		return unsoldCarDealershipId;
	}
	public void setUnsoldCarDealershipId(int unsoldCarDealershipId) {
		this.unsoldCarDealershipId = unsoldCarDealershipId;
	}
}
