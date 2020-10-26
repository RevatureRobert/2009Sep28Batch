package com.model;

public class Reimbursement 
{

	private float reimb_amount;
	private String reimb_description;
	private int reimb_author;
	private int reimb_status_id;
	private int reimb_type_id;
	

	public Reimbursement(float reimb_amount, String reimb_description, int reimb_author, int reimb_status_id,
			int reimb_type_id) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}

	public float getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(float reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public int getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}

	public int getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	public int getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}



	

}
