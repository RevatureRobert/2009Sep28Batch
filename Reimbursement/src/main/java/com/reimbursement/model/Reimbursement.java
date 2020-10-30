package com.reimbursement.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

public class Reimbursement {
	
	private int reimbursementId;
	private BigDecimal reimbursementAmount;
	private Timestamp submittedTime;
	private Timestamp resolvedTime;
	private String description;
	private byte[]receipt;
	private int authorId;
	private int resolverId;
	private int statusId;
	private int typeId;
	
	public Reimbursement() {}
	public Reimbursement(int reimbursementId, BigDecimal reimbursementAmount, Timestamp submittedTime,
			Timestamp resolvedTime, String description, byte[] receipt, int authorId, int resolverId, int statusId,
			int typeId) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementAmount = reimbursementAmount;
		this.submittedTime = submittedTime;
		this.resolvedTime = resolvedTime;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	public Reimbursement(int reimbursementId, BigDecimal reimbursementAmount, Timestamp submittedTime,
			Timestamp resolvedTime, String description, int authorId, int resolverId, int statusId, int typeId) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementAmount = reimbursementAmount;
		this.submittedTime = submittedTime;
		this.resolvedTime = resolvedTime;
		this.description = description;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public BigDecimal getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(BigDecimal reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public Timestamp getSubmittedTime() {
		return submittedTime;
	}

	public void setSubmittedTime(Timestamp submittedTime) {
		this.submittedTime = submittedTime;
	}

	public Timestamp getResolvedTime() {
		return resolvedTime;
	}

	public void setResolvedTime(Timestamp resolvedTime) {
		this.resolvedTime = resolvedTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getReceipt() {
		return receipt;
	}

	public void setReceipt(byte[] receipt) {
		this.receipt = receipt;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", reimbursementAmount=" + reimbursementAmount
				+ ", submittedTime=" + submittedTime + ", resolvedTime=" + resolvedTime + ", description=" + description
				+ ", receipt=" + Arrays.toString(receipt) + ", authorId=" + authorId + ", resolverId=" + resolverId
				+ ", statusId=" + statusId + ", typeId=" + typeId + "]";
	}
}
