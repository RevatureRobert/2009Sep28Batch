package com.reimbursement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.reimbursement.model.RecordDTO;
import com.reimbursement.model.User;
import com.reimbursement.util.DBConnector;

public class RecordDAO extends ReimbursementDAO {
	
	public List<RecordDTO> recordsForUser(User user) {
		List<RecordDTO> records = new LinkedList<>();
		boolean isManager = user.getRoleId() == 1 ? true : false;
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			String sql = "SELECT * FROM reimbursement_schema.complete_records"
					+ (isManager ? "" : " WHERE requestor = ?");
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			if(!isManager)
				ps.setString(1, user.getUsername());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				RecordDTO record = new RecordDTO();
				
				record.setId(rs.getInt("id"));
				record.setAmount(rs.getBigDecimal("amount").toPlainString());
				switch(rs.getInt("reimb_status_id")) {
				case 0:	
					record.setStatus("PENDING");
					break;
				case 1:
					record.setStatus("APPROVED");
					break;
				case 2:
					record.setStatus("REJECTED");
				}
				record.setSubmitted(rs.getTimestamp("submitted").toString());
				record.setResolved(rs.getTimestamp("resolved") == null ?
						"UNRESOLVED" : rs.getTimestamp("resolved").toString());
				record.setDescription(rs.getString("description"));
				switch(rs.getInt("reimb_type_id")) {
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
				
				if(isManager) {
					record.setReceipt(rs.getBytes("receipt"));
					record.setRequestor(rs.getString("requestor"));
					record.setResolver(rs.getString("resolver"));
				}
				
				records.add(record);
			}
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return records;
	}
}
