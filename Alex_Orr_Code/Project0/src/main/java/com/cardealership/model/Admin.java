package com.cardealership.model;

public class Admin extends User {
	
	private int adminId;
	private int dealershipId;
	
	
	public Admin(int adminId, int dealershipId, int userId, String userUserName, String userPassword, UserType userType, String userFirstName,
			String userLastName, String userEmail) {
		super(userId, userUserName, userPassword, userType, userFirstName, userLastName, userEmail);
		this.adminId = adminId;
		this.dealershipId = dealershipId;
	}
	@Override
	public String toString() {
		return super.toString()+" Admin [adminId=" + adminId + ", dealershipId=" + dealershipId + "]";
	}


	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public int getDealershipId() {
		return dealershipId;
	}


	public void setDealershipId(int dealershipId) {
		this.dealershipId = dealershipId;
	}
}
