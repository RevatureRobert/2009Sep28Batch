package com.reimbursement.backend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.reimbursement.dao.UserRoleDAO;
import com.reimbursement.model.UserRole;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRoleDaoTester {
	
	UserRoleDAO dao;
	
	@Before
	public void init() {
		dao = new UserRoleDAO();
	}
	
	@Test
	public void A_readsAllRecords() { // FINDALL
		List<UserRole> roles = dao.findAll();
		
		assertEquals(roles.get(0).getRole(), "employee");
	}
	
	@Test
	public void B_findsRecordById() { // FINDBYID
		UserRole testRole = dao.findById(1);
		
		assertEquals(testRole.getRole(), "manager");
	}
	
	@Test
	public void C_crudOps() { // CREATE, FINDBYUSERINPUT, FINDBYID, UPDATEBYID, DELETEBYID
		int roleCount = dao.findAll().size();
		
		UserRole role = new UserRole(2, "test_role");
		dao.create(role);
		UserRole roleFromDB = dao.findByUserInput("test_role");
		assertEquals(roleFromDB.getRoleId(), role.getRoleId()); // TESTS CREATE, FINDBYUSERINPUT
		
		roleFromDB = dao.findById(role.getRoleId());
		assertEquals(roleFromDB.getRole(), role.getRole()); // TESTS FINDBYID
		
		role.setRole("other_role");
		dao.updateById(role);
		roleFromDB = dao.findById(roleFromDB.getRoleId());
		assertEquals(role.getRole(), roleFromDB.getRole()); // TESTS UPDATEBYID
		
		dao.deleteById(role.getRoleId());
		assertEquals(roleCount, dao.findAll().size()); // TESTS DELETE
	}
	
	@Test
	public void D_findsRecordState() { // RECORDSTATEOF
		UserRole dummyRole = new UserRole();
		
		dummyRole.setRole("employee");
		dummyRole.setRoleId(0);
		
		assertEquals(dao.recordStateOf(dummyRole), "VALID RECORD");
	}
	
	@Test
	public void E_filtersByItem() { // FILTERBYITEM
		assertEquals(dao.filterByItem("").size(), 0);
	}
}
