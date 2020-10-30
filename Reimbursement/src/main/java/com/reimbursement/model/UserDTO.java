package com.reimbursement.model;

public class UserDTO {
	private String name;
	private int roleId;
	
	public UserDTO() {}
	public UserDTO(String name, int roleId) {
		super();
		this.name = name;
		this.roleId = roleId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
