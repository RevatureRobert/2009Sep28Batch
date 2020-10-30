package com.reimbursement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.reimbursement.model.ReimbursementType;
import com.reimbursement.util.DBConnector;

public class ReimbursementTypeDAO implements DBAccessor<ReimbursementType, Integer> {

	@Override
	public int create(ReimbursementType data) {
		int result = 0;
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			String sql = "INSERT INTO ers_reimbursement_type"
					+ " (reimb_type_id, reimb_type)"
					+ " VALUES"
					+ " (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, data.getTypeId());
			ps.setString(2, data.getType());
			
			result = ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<ReimbursementType> findAll() {
		List<ReimbursementType> ReimbursementTypes = new LinkedList<>();
		String sql = "SELECT * FROM ers_reimbursement_type";
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ReimbursementTypes.add(new ReimbursementType(
					rs.getInt("reimb_type_id"), rs.getString("reimb_type")));
			}
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return ReimbursementTypes;
	}

	@Override
	public ReimbursementType findById(Integer id) {
		ReimbursementType status = new ReimbursementType();
		String sql = "SELECT * FROM ers_reimbursement_type WHERE reimb_type_id = ?";
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				status = new ReimbursementType(
						rs.getInt("reimb_type_id"), rs.getString("reimb_type"));
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public ReimbursementType findByUserInput(String input) {
		ReimbursementType status = new ReimbursementType();
		String sql = "SELECT * FROM ers_reimbursement_type WHERE reimb_type = ?"; // INPUT IS REIMBURSEMENT TYPE
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, input);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				status = new ReimbursementType(
						rs.getInt("reimb_type_id"), rs.getString("reimb_type"));
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public String recordStateOf(ReimbursementType data) {
		String recordState = "INVALID RECORD";
		
		if(data.getType() == null) {
			return recordState;
		}
		
		String sql = "SELECT * FROM ers_reimbursement_type WHERE reimb_type_id = ?";
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, data.getType());
			
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
	public int updateById(ReimbursementType data) {
		int result = 0;
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			String sql = "UPDATE ers_reimbursement_type"
					+ " SET reimb_type = ? WHERE reimb_type_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, data.getType());
			ps.setInt(2, data.getTypeId());
			
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
			String sql = "DELETE FROM ers_reimbursement_type WHERE reimb_type_id = ?";
			
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
	public List<ReimbursementType> filterByItem(Object filterKey) {
		List<ReimbursementType> filteredReimbursementTypes = new LinkedList<>();
		
		return filteredReimbursementTypes;
	}
}
