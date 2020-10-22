package com.project1.model;

import java.io.OutputStream;
import java.sql.Timestamp;

public class Reimbursement {
	private int id;
	private double amount;
	private Timestamp submitTime;
	private Timestamp resolveTime;
	private String description;
	private OutputStream receipt;
	private User author;
	private User resolver;
	private ReimbursementStatus status;
	private ReimbursementType type;
	
	
	public Reimbursement(int id, double amount, Timestamp submitTime, Timestamp resolveTime, String description,
			OutputStream receipt, User author, User resolver, ReimbursementStatus status, ReimbursementType type) {
		this.id = id;
		this.amount = amount;
		this.submitTime = submitTime;
		this.resolveTime = resolveTime;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}
	
	public Reimbursement (int id, double amount, Timestamp submitTime, String description, User author, ReimbursementStatus status, ReimbursementType type) {
		this(id, amount, submitTime, null, description, null, author, null, status, type);
	}

	public double getAmount() {
		return amount;
	}

	public Timestamp getSubmitTime() {
		return submitTime;
	}

	public Timestamp getResolveTime() {
		return resolveTime;
	}

	public String getDescription() {
		return description;
	}

	public OutputStream getReceipt() {
		return receipt;
	}

	public User getAuthor() {
		return author;
	}

	public User getResolver() {
		return resolver;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	public ReimbursementType getType() {
		return type;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public void setResolveTime(Timestamp resolveTime) {
		this.resolveTime = resolveTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setReceipt(OutputStream receipt) {
		this.receipt = receipt;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	public void setType(ReimbursementType type) {
		this.type = type;
	}
	
	
	
}
