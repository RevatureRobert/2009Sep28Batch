package com.bankapp.model;

import java.util.Set;

public class Users {
	private String username;
	private String user_password;
	private String email;
	private boolean user_acc;
	private boolean emp_acc;
	private boolean cust_acc;
	private boolean has_checking;
	private double checking_balance;
	private boolean has_savings;
	private double savings_balance;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public boolean isUser_acc() {
		return user_acc;
	}

	public void setUser_acc(boolean user_acc) {
		this.user_acc = user_acc;
	}

	public boolean isEmp_acc() {
		return emp_acc;
	}

	public void setEmp_acc(boolean emp_acc) {
		this.emp_acc = emp_acc;
	}

	public boolean isCust_acc() {
		return cust_acc;
	}

	public void setCust_acc(boolean cust_acc) {
		this.cust_acc = cust_acc;
	}

	public boolean isHas_checking() {
		return has_checking;
	}

	public void setHas_checking(boolean has_checking) {
		this.has_checking = has_checking;
	}

	public double getChecking_balance() {
		return checking_balance;
	}

	public void setChecking_balance(double checking_balance) {
		this.checking_balance = checking_balance;
	}

	public boolean isHas_savings() {
		return has_savings;
	}

	public void setHas_savings(boolean has_savings) {
		this.has_savings = has_savings;
	}

	public double getSavings_balance() {
		return savings_balance;
	}

	public void setSavings_balance(double savings_balance) {
		this.savings_balance = savings_balance;
	}

	

	public Users(String username, String user_password, String email, boolean user_acc, boolean emp_acc,
			boolean cust_acc, boolean has_checking, double checking_balance, boolean has_savings,
			double savings_balance) {
		super();
		this.username = username;
		this.user_password = user_password;
		this.email = email;
		this.user_acc = user_acc;
		this.emp_acc = emp_acc;
		this.cust_acc = cust_acc;
		this.has_checking = has_checking;
		this.checking_balance = checking_balance;
		this.has_savings = has_savings;
		this.savings_balance = savings_balance;
	}

	@Override
	public String toString() {
		return "Users [Username=" + username + ", Password=" + user_password + ", Email=" + email + ", Is this a user account? "
				+ user_acc + ", Is this an employee account? " + emp_acc + ", Is this a customer account? " + cust_acc + ", Does this account have a checking account? " + has_checking
				+ ", What is the balance? " + ", Does this account have a savings account?" + has_savings + ", What is the balance?" + savings_balance + "]";
	}


	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

}

