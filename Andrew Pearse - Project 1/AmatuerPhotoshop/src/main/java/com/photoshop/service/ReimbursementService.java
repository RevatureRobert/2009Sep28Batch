package com.photoshop.service;

import java.util.List;

import com.photoshop.model.Reimbursement;
import com.photoshop.repo.ReimbursementDao;

public class ReimbursementService {

	ReimbursementDao rd;
	
	public ReimbursementService() {
		this (new ReimbursementDao());
	}
	
	public ReimbursementService(ReimbursementDao rd) {
		this.rd = rd;
	}
	
	public List<Reimbursement> findAll(){
		return rd.findAll();
	}
	
	public Reimbursement findById(int i) {
		return rd.findById(i);
	}
	
	public int request(Reimbursement reimbursement) {
		return rd.create(reimbursement);
	}
	
	public int updateRequest(Reimbursement reimbursement) {
		return rd.update(reimbursement);
	}
	
	public List<Reimbursement> findAllByUser(int i){
		return rd.findAllByUser(i);
	}
}
