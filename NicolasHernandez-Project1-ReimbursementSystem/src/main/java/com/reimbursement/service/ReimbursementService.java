package com.reimbursement.service;

import java.util.List;

import com.reimbursement.dao.DBAccessor;
import com.reimbursement.dao.ReimbursementDAO;
import com.reimbursement.dao.ReimbursementStatusDAO;
import com.reimbursement.dao.ReimbursementTypeDAO;
import com.reimbursement.dao.UserDAO;
import com.reimbursement.model.Reimbursement;
import com.reimbursement.model.ReimbursementStatus;
import com.reimbursement.model.ReimbursementType;
import com.reimbursement.model.User;

public class ReimbursementService {
	private DBAccessor<Reimbursement, Integer> reimbDao;
	private DBAccessor<User, Integer> userDao;
	private DBAccessor<ReimbursementStatus, Integer> statusDao;
	private DBAccessor<ReimbursementType, Integer> typeDao;
	
	public ReimbursementService() {
		this(new ReimbursementDAO(), new UserDAO(), new ReimbursementStatusDAO(), new ReimbursementTypeDAO());
	}
	public ReimbursementService(DBAccessor<Reimbursement, Integer> reimbDao, DBAccessor<User, Integer> userDao,
			DBAccessor<ReimbursementStatus, Integer> statusDao, DBAccessor<ReimbursementType, Integer> typeDao) {
		super();
		this.reimbDao = reimbDao;
		this.userDao = userDao;
		this.statusDao = statusDao;
		this.typeDao = typeDao;
	}
	
	public List<Reimbursement> retrieveReimbursements(User user){
		return reimbDao.filterByItem(user);
	}
}
