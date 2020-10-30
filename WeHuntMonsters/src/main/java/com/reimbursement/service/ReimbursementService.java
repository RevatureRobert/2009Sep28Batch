package com.reimbursement.service;

import java.sql.Timestamp;
import java.util.List;

import com.reimbursement.dao.DBAccessor;
import com.reimbursement.dao.ReimbursementDAO;
import com.reimbursement.model.Reimbursement;
import com.reimbursement.model.User;

public class ReimbursementService {
	private DBAccessor<Reimbursement, Integer> reimbDao;
	
	public ReimbursementService() {
		this(new ReimbursementDAO());
	}
	public ReimbursementService(DBAccessor<Reimbursement, Integer> reimbDao) {
		super();
		this.reimbDao = reimbDao;
	}
	
	public List<Reimbursement> retrieveReimbursements(User user){
		if(user.getRoleId() == 0)
			return reimbDao.filterByItem(user);
		else
			return reimbDao.findAll();
	}
	
	public Reimbursement save(Reimbursement reimb, User user) {
		reimbDao.create(reimb);
		
		List<Reimbursement> newList = retrieveReimbursements(user);
		
		return newList.get(newList.size() - 1);
	}
	
	public Reimbursement approveById(int approvedRecordId, int resolverId) {
		Reimbursement reimb = reimbDao.findById(approvedRecordId);
		
		reimb.setResolvedTime(new Timestamp(System.currentTimeMillis()));
		reimb.setResolverId(resolverId);
		
		reimb.setStatusId(1);
		
		reimbDao.updateById(reimb);
		
		return reimb;
	}
	public Reimbursement denyById(int deniedRecordId, int resolverId) {
		Reimbursement reimb = reimbDao.findById(deniedRecordId);
		
		reimb.setResolvedTime(new Timestamp(System.currentTimeMillis()));
		reimb.setResolverId(resolverId);
		
		reimb.setStatusId(2);
		
		reimbDao.updateById(reimb);
		
		return reimb;
	}
}
