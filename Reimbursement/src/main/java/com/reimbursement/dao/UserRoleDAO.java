package com.reimbursement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.reimbursement.model.UserRole;
import com.reimbursement.util.DBConnector;

public class UserRoleDAO implements DBAccessor<UserRole, Integer> {
	
	@Override
	public int create(UserRole data) {
		int result = 0;
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			String sql = "INSERT INTO reimbursement_schema.ers_user_roles"
					+ " (ers_user_role_id, user_role)"
					+ " VALUES"
					+ " (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, data.getRoleId());
			ps.setString(2, data.getRole());
			
			result = ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<UserRole> findAll() {
		List<UserRole> UserRolees = new LinkedList<>();
		String sql = "SELECT * FROM reimbursement_schema.ers_user_roles";
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				UserRolees.add(new UserRole(
					rs.getInt("ers_user_role_id"), rs.getString("user_role")));
			}
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return UserRolees;
	}

	@Override
	public UserRole findById(Integer id) {
		UserRole status = new UserRole();
		String sql = "SELECT * FROM reimbursement_schema.ers_user_roles WHERE ers_user_role_id = ?";
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				status = new UserRole(
						rs.getInt("ers_user_role_id"), rs.getString("user_role"));
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public UserRole findByUserInput(String input) {
		UserRole status = new UserRole();
		String sql = "SELECT * FROM reimbursement_schema.ers_user_roles WHERE user_role = ?"; // INPUT IS ROLE NAME
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, input);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				status = new UserRole(
						rs.getInt("ers_user_role_id"), rs.getString("user_role"));
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public String recordStateOf(UserRole data) {
		String recordState = "INVALID RECORD";
		
		if(data.getRole() == null) {
			return recordState;
		}
		
		String sql = "SELECT * FROM reimbursement_schema.ers_user_roles WHERE ers_user_role_id = ? and user_role = ?";
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, data.getRoleId());
			ps.setString(2, data.getRole());
			
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
	public int updateById(UserRole data) {
		int result = 0;
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			String sql = "UPDATE reimbursement_schema.ers_user_roles"
					+ " SET user_role = ? WHERE ers_user_role_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, data.getRole());
			ps.setInt(2, data.getRoleId());
			
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
			String sql = "DELETE FROM reimbursement_schema.ers_user_roles WHERE ers_user_role_id = ?";
			
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
	public List<UserRole> filterByItem(Object filterKey) {
		List<UserRole> filteredUserRoles = new LinkedList<>();
		
		return filteredUserRoles;
	}
}
