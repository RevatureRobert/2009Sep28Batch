package com.reimbursement.dao;

import java.util.List;

public interface DBAccessor <TransferredObject, IdentifierObject>{
	// Create
	int create(TransferredObject data);
	
	// Read
	List<TransferredObject> findAll();
	List<TransferredObject> filterByItem(Object filterKey);
	TransferredObject findById(IdentifierObject id);
	TransferredObject findByUserInput(String input);
	String recordStateOf(TransferredObject data); // existence checks & login validation
	
	// Update
	int updateById(TransferredObject data);
	
	// Delete
	int deleteById(IdentifierObject id);
}
