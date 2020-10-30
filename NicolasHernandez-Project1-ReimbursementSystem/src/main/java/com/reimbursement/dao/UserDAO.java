package com.reimbursement.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import com.reimbursement.model.User;
import com.reimbursement.util.DBConnector;

public class UserDAO implements DBAccessor<User, Integer> {

	@Override
	public int create(User data) {
		int result = 0;
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			String sql = "INSERT INTO ers_users"
					+ " (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)"
					+ " VALUES"
					+ " (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, data.getUsername());
			ps.setString(2, data.getPassword());
			ps.setString(3, data.getFirstName());
			ps.setString(4, data.getLastName());
			ps.setString(5, data.getEmail());
			ps.setInt(6, data.getRoleId());
			
			result = ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new LinkedList<>();
		String sql = "SELECT * FROM ers_users";
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				users.add(new User(
					rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"),
					rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"),
					rs.getInt("user_role_id")));
			}
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User findById(Integer id) {
		User user = new User();
		String sql = "SELECT * FROM ers_users WHERE ers_users_id = ?";
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				user = new User(
						rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"),
						rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"),
						rs.getInt("user_role_id"));
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User findByUserInput(String input) {
		User user = new User();
		String sql = "SELECT * FROM ers_users WHERE ers_username = ?"; // INPUT IS USERNAME
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, input);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				user = new User(
						rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"),
						rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"),
						rs.getInt("user_role_id"));
			
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public String recordStateOf(User data) { // CHECKS USERNAME & PASSWORD
		String recordState = "INVALID USERNAME";
		
		if(data.getUsername() == null || data.getPassword() == null) {
			return recordState;
		}
		
		String sql = "{? = CALL validation_code_of(?, ?)}";
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, data.getUsername());
			cs.setString(3, data.getPassword());
			
			cs.execute();
			
			int validationCode = cs.getInt(1);
			
			switch(validationCode) {
			case 0:
				recordState = "INVALID USERNAME";
				break;
			case 1:
				recordState = "INVALID PASSWORD";
				break;
			case 2:
				recordState = "VALID";
			}
			
			cs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return recordState;
	}

	@Override
	public int updateById(User data) {
		int result = 0;
		
		try(Connection conn = DBConnector.getInstance().getConnection()){
			String sql = "UPDATE ers_users SET"
					+ " ers_username = ?, ers_password = ?,"
					+ " user_first_name = ?, user_last_name = ?,"
					+ " user_email = ?, user_role_id = ?"
					+ " WHERE"
					+ " ers_users_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, data.getUsername());
			ps.setString(2, data.getPassword());
			ps.setString(3, data.getFirstName());
			ps.setString(4, data.getLastName());
			ps.setString(5, data.getEmail());
			ps.setInt(6, data.getRoleId());
			
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
			String sql = "DELETE FROM ers_users WHERE ers_users_id = ?";
			
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
	public List<User> filterByItem(Object filterKey) {
		List<User> filteredUsers = new LinkedList<>();
		
		return filteredUsers;
	}
}
