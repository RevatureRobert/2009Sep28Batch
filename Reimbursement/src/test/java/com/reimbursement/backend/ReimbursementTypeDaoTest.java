package com.reimbursement.backend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.reimbursement.dao.ReimbursementTypeDAO;
import com.reimbursement.model.ReimbursementType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReimbursementTypeDaoTest {
	ReimbursementTypeDAO dao;
	
	@Before
	public void init() {
		dao = new ReimbursementTypeDAO();
	}
	
	@Test
	public void A_readsAllRecords() { // FINDALL
		List<ReimbursementType> reimbTypes = dao.findAll();
		
		assertEquals(reimbTypes.get(0).getType(), "training");
	}
	
	@Test
	public void B_findsRecordById() { // FINDBYID
		ReimbursementType testReimbType = dao.findById(2);
		
		assertEquals(testReimbType.getType(), "supplies");
	}
	
	@Test
	public void C_crudOps() { // CREATE, FINDBYUSERINPUT, FINDBYID, UPDATEBYID, DELETEBYID
		int reimbTypeCount = dao.findAll().size();
		
		ReimbursementType reimbType = new ReimbursementType(7, "test_type");
		dao.create(reimbType);
		ReimbursementType reimbTypeFromDB = dao.findByUserInput("test_type");
		assertEquals(reimbTypeFromDB.getTypeId(), reimbType.getTypeId()); // TESTS CREATE, FINDBYUSERINPUT
		
		reimbTypeFromDB = dao.findById(reimbType.getTypeId());
		assertEquals(reimbTypeFromDB.getType(), reimbType.getType()); // TESTS FINDBYID
		
		reimbType.setType("other_type");
		dao.updateById(reimbType);
		reimbTypeFromDB = dao.findById(reimbTypeFromDB.getTypeId());
		assertEquals(reimbType.getType(), reimbTypeFromDB.getType()); // TESTS UPDATEBYID
		
		dao.deleteById(reimbType.getTypeId());
		assertEquals(reimbTypeCount, dao.findAll().size()); // TESTS DELETE
	}
	
	@Test
	public void D_findsRecordState() { // RECORDSTATEOF
		ReimbursementType dummyReimbType = new ReimbursementType();
		
		dummyReimbType.setType("travel");
		dummyReimbType.setTypeId(1);
		
		assertEquals(dao.recordStateOf(dummyReimbType), "VALID RECORD");
	}
	
	@Test
	public void E_filtersByItem() { // FILTERBYITEM
		assertEquals(dao.filterByItem("").size(), 0);
	}
}
