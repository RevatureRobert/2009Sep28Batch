package com.reimbursement.backend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.reimbursement.dao.ReimbursementStatusDAO;
import com.reimbursement.model.ReimbursementStatus;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReimbursementStatusDaoTester {
	ReimbursementStatusDAO dao;
	
	@Before
	public void init() {
		dao = new ReimbursementStatusDAO();
	}
	
	@Test
	public void A_readsAllRecords() { // FINDALL
		List<ReimbursementStatus> reimbStatuss = dao.findAll();
		
		assertEquals(reimbStatuss.get(0).getStatus(), "PENDING");
	}
	
	@Test
	public void B_findsRecordById() { // FINDBYID
		ReimbursementStatus testReimbStatus = dao.findById(2);
		
		assertEquals(testReimbStatus.getStatus(), "REJECTED");
	}
	
	@Test
	public void C_crudOps() { // CREATE, FINDBYUSERINPUT, FINDBYID, UPDATEBYID, DELETEBYID
		int reimbStatusCount = dao.findAll().size();
		
		ReimbursementStatus reimbStatus = new ReimbursementStatus(7, "test_stat");
		dao.create(reimbStatus);
		ReimbursementStatus reimbStatusFromDB = dao.findByUserInput("test_stat");
		assertEquals(reimbStatusFromDB.getStatusId(), reimbStatus.getStatusId()); // TESTS CREATE, FINDBYUSERINPUT
		
		reimbStatusFromDB = dao.findById(reimbStatus.getStatusId());
		assertEquals(reimbStatusFromDB.getStatus(), reimbStatus.getStatus()); // TESTS FINDBYID
		
		reimbStatus.setStatus("other_type");
		dao.updateById(reimbStatus);
		reimbStatusFromDB = dao.findById(reimbStatusFromDB.getStatusId());
		assertEquals(reimbStatus.getStatus(), reimbStatusFromDB.getStatus()); // TESTS UPDATEBYID
		
		dao.deleteById(reimbStatus.getStatusId());
		assertEquals(reimbStatusCount, dao.findAll().size()); // TESTS DELETE
	}
	
	@Test
	public void D_findsRecordState() { // RECORDSTATEOF
		ReimbursementStatus dummyReimbStatus = new ReimbursementStatus();
		
		dummyReimbStatus.setStatus("APPROVED");
		dummyReimbStatus.setStatusId(1);
		
		assertEquals(dao.recordStateOf(dummyReimbStatus), "VALID RECORD");
	}
	
	@Test
	public void E_filtersByItem() { // FILTERBYITEM
		assertEquals(dao.filterByItem("").size(), 0);
	}
}
