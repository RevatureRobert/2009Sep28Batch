package com.reimbursement.controller;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.model.RecordDTO;
import com.reimbursement.model.Reimbursement;
import com.reimbursement.model.User;
import com.reimbursement.service.RecordService;
import com.reimbursement.service.ReimbursementService;


public class InboundDataController {
	private RecordService recsvc;
	private ReimbursementService reimbsvc;
	
	public InboundDataController(RecordService recsvc, ReimbursementService reimbsvc) {
		super();
		this.recsvc = recsvc;
		this.reimbsvc = reimbsvc;
	}
	public InboundDataController() {
		this(new RecordService(), new ReimbursementService());
	}
	
	
	public void newRecord(HttpServletRequest req, HttpServletResponse res) {
		res.setContentType("text/json");
		
		User user = (User) req.getSession().getAttribute("user");
		
		RecordDTO newRecord;
		try {
			newRecord = new ObjectMapper().readValue(req.getInputStream(), RecordDTO.class);
			
			
			
			if(newRecord.getAmount().isEmpty() || newRecord.getAmount().charAt(0) == '-'
					|| newRecord.getAmount().charAt(0) == '0')
				return;
			
			newRecord.setRequestor(user.getUsername());
			
			newRecord = recsvc.save(newRecord, user);
			
			String str = new ObjectMapper().writeValueAsString(newRecord);
			
//			System.out.println(str);
			
			res.getWriter().println(str);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void approveRecord(HttpServletRequest req, HttpServletResponse res) {
		res.setContentType("text/json");
		
		try {
//			int approvedRecordId = Integer.parseInt(new String(req.getInputStream().readAllBytes()));
			int approvedRecordId = Integer.parseInt(IOUtils.toString(req.getInputStream(), Charset.forName("UTF-8")));
			User resolver = (User) req.getSession().getAttribute("user");
			
			Reimbursement updatedReimb = reimbsvc.approveById(approvedRecordId, resolver.getUserId());
			
			String str = new ObjectMapper().writeValueAsString(
					recsvc.constructResolvedRecord(updatedReimb, resolver));
			
			res.getWriter().println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void denyRecord(HttpServletRequest req, HttpServletResponse res) {
		res.setContentType("text/json");
		
		try {
			int deniedRecordId = Integer.parseInt(IOUtils.toString(req.getInputStream(), Charset.forName("UTF-8")));
			User resolver = (User) req.getSession().getAttribute("user");
			
			Reimbursement updatedReimb = reimbsvc.denyById(deniedRecordId, resolver.getUserId());
			
			String str = new ObjectMapper().writeValueAsString(
					recsvc.constructResolvedRecord(updatedReimb, resolver));
			
			res.getWriter().println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
