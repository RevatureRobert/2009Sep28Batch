package com.reimbursement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.model.RecordDTO;
import com.reimbursement.model.User;
import com.reimbursement.model.UserDTO;
import com.reimbursement.service.RecordService;

public class OutboundDataController {
	private RecordService recsvc;
	
	public OutboundDataController(RecordService recsvc) {
		super();
		this.recsvc = recsvc;
	}
	public OutboundDataController() {
		this(new RecordService());
	}
	
	

	public void loginWarningStatus(HttpServletRequest req, HttpServletResponse res) {
		res.setContentType("text/json");
		
		try {
			String str = new ObjectMapper().writeValueAsString(
					req.getSession().getAttribute("warning-message"));
			
			if(str.equals("null") || str == null)
				str = new ObjectMapper().writeValueAsString("");
			
//			System.out.println(str);
			
			res.getWriter().println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void currentUser(HttpServletRequest req, HttpServletResponse res) {
		res.setContentType("text/json");
		
		User user = (User)req.getSession().getAttribute("user");
		
		UserDTO dto = new UserDTO(user.getFirstName() + " " + user.getLastName(), user.getRoleId());
		
		try {
			String str = new ObjectMapper().writeValueAsString(dto);
			
//			System.out.println(str);
			
			res.getWriter().println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void records(HttpServletRequest req, HttpServletResponse res) {
		res.setContentType("text/json");
		
		User user = (User) req.getSession().getAttribute("user");
		
//		System.out.println("Role id: " + user.getRoleId());
		
		List<RecordDTO> records = recsvc.getRecordsFor(user);
		
		try {
			String str = new ObjectMapper().writeValueAsString(records);
			
//			System.out.println(str);
			
			res.getWriter().println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
