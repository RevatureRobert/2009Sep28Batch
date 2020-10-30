package com.reimbursement.midend;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import com.reimbursement.dao.ReimbursementDAO;
import com.reimbursement.model.RecordDTO;
import com.reimbursement.model.Reimbursement;
import com.reimbursement.model.User;
import com.reimbursement.service.RecordService;
import com.reimbursement.service.UserService;

public class RecordServiceTest {
	
	RecordService recsvc;
	User employee;
	User manager;
	
	@Before
	public void init() {
		recsvc = new RecordService();
		
		UserService usvc = new UserService();
		employee = usvc.login("TEST_EMPLOYEE");
		manager = usvc.login("manager");
	}
	
	@Test
	public void trySaving() {
		RecordDTO record = new RecordDTO(0, "4321.09", "2004-10-19 10:23:54", "2005-10-19 10:23:54", "Record service tester record",
				new byte[] {(byte)7, (byte)12}, "TEST_EMPLOYEE", "nietzsche", "APPROVED", "safety");
		RecordDTO trueRecord = recsvc.save(record, employee);
		
		assertEquals(record.getDescription(), trueRecord.getDescription());
		
		new ReimbursementDAO().deleteById(trueRecord.getId());
	}
	
	@Test
	public void tryResolvingReimbursementIntoApprovedRecord() {
		Reimbursement reimb = new Reimbursement();
		reimb.setReimbursementAmount(new BigDecimal("43.21"));
		reimb.setSubmittedTime(new Timestamp(System.currentTimeMillis()));
		reimb.setDescription(
			"this description is a testing description used only for testing ipsum lorem");
		reimb.setReceipt(new byte[] {(byte)1, (byte)2});
		reimb.setAuthorId(4);
		reimb.setStatusId(2);
		reimb.setTypeId(4);
		
		assertEquals("manager", recsvc.constructResolvedRecord(reimb, manager).getResolver());
	}
}
