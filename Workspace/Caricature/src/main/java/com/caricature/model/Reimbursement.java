package com.caricature.model;

import java.time.LocalDateTime;

public class Reimbursement {

	private int id;
	private float amount;
	private LocalDateTime submitDate;
	private LocalDateTime resolveDate;
	private String description;
	private byte[] recipt;
	private User author;
	private User resolver;
	private String status;
	private String type;

	public Reimbursement() {
		super();
	}

	public Reimbursement(int id, float amount, LocalDateTime submitDate, LocalDateTime resolveDate, String description,
			byte[] recipt, User author, User resolver, String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitDate = submitDate;
		this.resolveDate = resolveDate;
		this.description = description;
		this.recipt = recipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public LocalDateTime getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDateTime submitDate) {
		this.submitDate = submitDate;
	}

	public LocalDateTime getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(LocalDateTime resolveDate) {
		this.resolveDate = resolveDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getRecipt() {
		return recipt;
	}

	public void setRecipt(byte[] recipt) {
		this.recipt = recipt;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
