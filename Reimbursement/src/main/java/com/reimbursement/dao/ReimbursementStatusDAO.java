package com.reimbursement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.reimbursement.model.ReimbursementStatus;
import com.reimbursement.util.DBConnector;

public class ReimbursementStatusDAO implements DBAccessor<ReimbursementStatus, Integer> {

	@Override
	public int create(ReimbursementStatus data) {
		int result = 0;
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			String sql = "INSERT INTO reimbursement_schema.ers_reimbursement_status"
					+ " (reimb_status_id, reimb_status)"
					+ " VALUES"
					+ " (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, data.getStatusId());
			ps.setString(2, data.getStatus());
			
			result = ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<ReimbursementStatus> findAll() {
		List<ReimbursementStatus> reimbursementStatuses = new LinkedList<>();
		String sql = "SELECT * FROM reimbursement_schema.ers_reimbursement_status";
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbursementStatuses.add(new ReimbursementStatus(
					rs.getInt("reimb_status_id"), rs.getString("reimb_status")));
			}
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursementStatuses;
	}

	@Override
	public ReimbursementStatus findById(Integer id) {
		ReimbursementStatus status = new ReimbursementStatus();
		String sql = "SELECT * FROM reimbursement_schema.ers_reimbursement_status WHERE reimb_status_id = ?";
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				status = new ReimbursementStatus(
						rs.getInt("reimb_status_id"), rs.getString("reimb_status"));
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public ReimbursementStatus findByUserInput(String input) {
		ReimbursementStatus status = new ReimbursementStatus();
		String sql = "SELECT * FROM reimbursement_schema.ers_reimbursement_status WHERE reimb_status = ?"; // INPUT IS STATUS NAME
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, input);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				status = new ReimbursementStatus(
						rs.getInt("reimb_status_id"), rs.getString("reimb_status"));
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public String recordStateOf(ReimbursementStatus data) {
		String recordState = "INVALID RECORD";
		
		if(data.getStatus() == null) {
			return recordState;
		}
		
		String sql = "SELECT * FROM reimbursement_schema.ers_reimbursement_status WHERE reimb_status_id = ? AND reimb_status = ?";
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, data.getStatusId());
			ps.setString(2, data.getStatus());
			
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
	public int updateById(ReimbursementStatus data) {
		int result = 0;
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			String sql = "UPDATE reimbursement_schema.ers_reimbursement_status"
					+ " SET reimb_status = ? WHERE reimb_status_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, data.getStatus());
			ps.setInt(2, data.getStatusId());
			
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
			String sql = "DELETE FROM reimbursement_schema.ers_reimbursement_status WHERE reimb_status_id = ?";
			
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
	public List<ReimbursementStatus> filterByItem(Object filterKey) {
		List<ReimbursementStatus> filteredReimbursementStatuses = new LinkedList<>();
		
		return filteredReimbursementStatuses;
	}

}
