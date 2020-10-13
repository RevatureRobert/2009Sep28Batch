package com.cardealership.service;

import com.cardealership.model.Admin;
import com.cardealership.repo.AdminDao;

public class AdminService {
	AdminDao ad;
	
	public AdminService() {
		super();
		this.ad = new AdminDao();
	}
	
	
}
