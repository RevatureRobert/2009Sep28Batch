package com.reimbursement.backend;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.reimbursement.dao.ReimbursementDAO;
import com.reimbursement.model.Reimbursement;
import com.reimbursement.model.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReimbursementDaoTester {
	ReimbursementDAO dao;
	
	@Before
	public void init() {
		dao = new ReimbursementDAO();
	}
	
	@Test
	public void A_readsAllRecords() { // FINDALL
		List<Reimbursement> reimbs = dao.findAll();
		
		assertEquals(reimbs.get(0).getDescription(), "test entry");
	}
	
	@Test
	public void B_findsRecordById() { // FINDBYID
		Reimbursement testReimb = dao.findById(2);
		
		assertEquals(testReimb.getReimbursementAmount(), new BigDecimal("0.05"));
	}
	
	@Test
	public void C_crudOps() { // CREATE, FINDBYUSERINPUT, FINDBYID, UPDATEBYID, DELETEBYID
		int reimbCount = dao.findAll().size();
		
		Reimbursement reimb = new Reimbursement();
		reimb.setReimbursementAmount(new BigDecimal("43.21"));
		reimb.setSubmittedTime(new Timestamp(System.currentTimeMillis()));
		reimb.setDescription(
			"this description is a testing description used only for testing ipsum lorem");
		reimb.setReceipt(new byte[] {(byte)1, (byte)2});
		reimb.setAuthorId(4);
		reimb.setStatusId(0);
		reimb.setTypeId(4);
		
		dao.create(reimb);
		Reimbursement reimbFromDB = dao.findByUserInput(
			"this description is a testing description used only for testing ipsum lorem");
		assertEquals(reimbFromDB.getTypeId(), reimb.getTypeId()); // TESTS CREATE, FINDBYUSERINPUT
		
		reimb.setReimbursementId(reimbFromDB.getReimbursementId());
		reimbFromDB = dao.findById(reimb.getReimbursementId());
		assertEquals(reimbFromDB.getSubmittedTime().toString(), reimb.getSubmittedTime().toString()); // TESTS FINDBYID
		
		reimb.setDescription("This is an updated description!");
		dao.updateById(reimb);
		reimbFromDB = dao.findById(reimbFromDB.getReimbursementId());
		assertEquals(reimb.getDescription(), reimbFromDB.getDescription()); // TESTS UPDATEBYID
		
		dao.deleteById(reimb.getReimbursementId());
		assertEquals(reimbCount, dao.findAll().size()); // TESTS DELETE
	}
	
	@Test
	public void D_findsRecordState() { // RECORDSTATEOF
		Reimbursement dummyReimb = new Reimbursement();
		
		dummyReimb.setDescription("travel");
		dummyReimb.setReimbursementId(1);
		
		assertEquals(dao.recordStateOf(dummyReimb), "VALID RECORD");
	}
	
	@Test
	public void E_filtersByItem() { // FILTERBYITEM
		User user = new User();
		
		user.setUserId(4);
		
		assertEquals(dao.filterByItem(user).size(), 2);
	}
}
