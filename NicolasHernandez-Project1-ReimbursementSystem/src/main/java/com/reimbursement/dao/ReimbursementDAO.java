package com.reimbursement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.reimbursement.model.Reimbursement;
import com.reimbursement.model.User;
import com.reimbursement.util.DBConnector;

public class ReimbursementDAO implements DBAccessor<Reimbursement, Integer> {

	@Override
	public int create(Reimbursement data) {
		int result = 0;
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			String sql = "INSERT INTO ers_reimbursement"
					+ " (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt,"
					+ " reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)"
					+ " VALUES"
					+ " (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setBigDecimal(1, data.getReimbursementAmount());
			ps.setTimestamp(2, data.getSubmittedTime());
			ps.setTimestamp(3, data.getResolvedTime());
			ps.setString(4, data.getDescription());
			ps.setBytes(5, data.getReceipt());
			ps.setInt(6, data.getAuthorId());
			ps.setInt(7, data.getResolverId());
			ps.setInt(8, data.getStatusId());
			ps.setInt(9, data.getTypeId());
			
			result = ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> reimbursements = new LinkedList<>();
		String sql = "SELECT * FROM ers_reimbursement";
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbursements.add(new Reimbursement(
					rs.getInt("reimb_id"), rs.getBigDecimal("reimb_amount"),
					rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
					rs.getString("reimb_description"), rs.getBytes("reimb_receipt"),
					rs.getInt("reimb_author"), rs.getInt("reimb_resolver"),
					rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id")));
			}
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public Reimbursement findById(Integer id) {
		Reimbursement reimbursement = new Reimbursement();
		String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				reimbursement = new Reimbursement(
						rs.getInt("reimb_id"), rs.getBigDecimal("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"), rs.getBytes("reimb_receipt"),
						rs.getInt("reimb_author"), rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursement;
	}

	@Override
	public Reimbursement findByUserInput(String input) {
		Reimbursement Reimbursement = new Reimbursement();
		String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?"; // INPUT IS REIMBURSEMENT ID ...
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, input);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				Reimbursement = new Reimbursement(
						rs.getInt("reimb_id"), rs.getBigDecimal("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"), rs.getBytes("reimb_receipt"),
						rs.getInt("reimb_author"), rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return Reimbursement;
	}

	@Override
	public String recordStateOf(Reimbursement data) { // ONLY CHECKS EXISTENCE
		String recordState = "INVALID RECORD";
		
		if(data.getReimbursementId() == 0) {
			return recordState;
		}
		
		String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, data.getReimbursementId());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				recordState = "VALID RECORD";
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return recordState;
	}

	@Override
	public int updateById(Reimbursement data) {
		int result = 0;
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			String sql = "UPDATE ers_reimbursement SET"
					+ " reimb_amount = ?, reimb_submitted = ?, reimb_resolved = ?,"
					+ " reimb_description = ?, reimb_receipt = ?,"
					+ " reimb_author = ?, reimb_resolver = ?,"
					+ " reimb_status_id = ?, reimb_type_id = ?"
					+ " WHERE"
					+ " reimb_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setBigDecimal(1, data.getReimbursementAmount());
			ps.setTimestamp(2, data.getSubmittedTime());
			ps.setTimestamp(3, data.getResolvedTime());
			ps.setString(4, data.getDescription());
			ps.setBytes(5, data.getReceipt());
			ps.setInt(6, data.getAuthorId());
			ps.setInt(7, data.getResolverId());
			ps.setInt(8, data.getStatusId());
			ps.setInt(9, data.getTypeId());
			
			ps.setInt(10, data.getReimbursementId());
			
			result = ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteById(Integer id) {
		int result = 0;
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			String sql = "DELETE FROM ers_reimbursement WHERE reimb_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			result = ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Reimbursement> filterByItem(Object filterKey) {
		List<Reimbursement> filteredReimbursements = new LinkedList<>();
		
		if(filterKey instanceof User) { // filters by users
			User userObject = (User)filterKey;
			
			try(Connection conn = DBConnector.getInstance().getConnection()){
				PreparedStatement ps = conn.prepareStatement(
						"SELECT * FROM ers_reimbursement WHERE reimb_author = ?");
				
				ps.setInt(0, userObject.getUserId());
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					filteredReimbursements.add(new Reimbursement(
						rs.getInt("reimb_id"), rs.getBigDecimal("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"), rs.getBytes("reimb_receipt"),
						rs.getInt("reimb_author"), rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id")));
				}
				
				rs.close();
				ps.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return filteredReimbursements;
	}
}
