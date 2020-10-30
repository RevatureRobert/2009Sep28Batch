package com.reimbursement.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.reimbursement.dao.RecordDAO;
import com.reimbursement.dao.UserDAO;
import com.reimbursement.model.RecordDTO;
import com.reimbursement.model.Reimbursement;
import com.reimbursement.model.User;

public class RecordService {
	private RecordDAO rdao;
	private UserDAO udao;
	
	public RecordService() { this(new RecordDAO(), new UserDAO()); }
	public RecordService(RecordDAO rdao, UserDAO udao) {
		super();
		this.rdao = rdao;
		this.udao = udao;
	}

	public List<RecordDTO> getRecordsFor(User user) {
		return rdao.recordsForUser(user);
	}
	
	public RecordDTO save(RecordDTO newRecord, User user) {
		Reimbursement reimb = newReimbursementObjectFor(newRecord, user);
		
		reimb = new ReimbursementService().save(reimb, user);
		
		List<RecordDTO> records = getRecordsFor(user);
		
//		for(RecordDTO record: records)
//			System.out.println(record.toString());
		
		return records.get(0);
	}
	
	public RecordDTO constructResolvedRecord(Reimbursement reimb, User resolver) {
		RecordDTO record = new RecordDTO();
		
		record.setId(reimb.getReimbursementId());
		record.setAmount(reimb.getReimbursementAmount().toPlainString());
		switch(reimb.getStatusId()) {
		case 0:	
			record.setStatus("PENDING");
			break;
		case 1:
			record.setStatus("APPROVED");
			break;
		case 2:
			record.setStatus("REJECTED");
		}
		record.setSubmitted(reimb.getSubmittedTime().toString());
		record.setResolved(reimb.getResolvedTime() == null ?
				"UNRESOLVED" : reimb.getResolvedTime().toString());
		record.setDescription(reimb.getDescription());
		switch(reimb.getTypeId()) {
		case 0:
			record.setType("training");
			break;
		case 1:
			record.setType("travel");
			break;
		case 2:
			record.setType("supplies");
			break;
		case 3:
			record.setType("safety");
			break;
		case 4:
			record.setType("other");
		}
		
		if(resolver.getRoleId() == 1) {
			record.setReceipt(record.getReceipt());
			record.setRequestor(udao.findById(reimb.getAuthorId()).getUsername());
			record.setResolver(resolver.getUsername());
		}
		
		return record;
	}
	
	private Reimbursement newReimbursementObjectFor(RecordDTO newRecord, User user) {
		Reimbursement result = new Reimbursement();
		
		result.setReimbursementAmount(new BigDecimal(newRecord.getAmount()));
		result.setSubmittedTime(new Timestamp(System.currentTimeMillis()));
		result.setDescription(newRecord.getDescription());
		result.setReceipt(newRecord.getReceipt());
		result.setAuthorId(user.getUserId());
		result.setStatusId(0); // dummy data
		String type = newRecord.getType();
		switch(type) {
		case "training":
			result.setTypeId(0);
			break;
		case "travel":
			result.setTypeId(1);
			break;
		case "supplies":
			result.setTypeId(2);
			break;
		case "safety":
			result.setTypeId(3);
			break;
		case "other":
			result.setTypeId(4);
		}
		
		return result;
	}
}