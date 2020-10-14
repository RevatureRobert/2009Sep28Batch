package com.car_dealership_cli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.car_dealership_cli.model.User;
import com.car_dealership_cli.repo.DAOContract;
import com.car_dealership_cli.repo.DAOUtilities;

public class UserDAO implements DAOContract<User, Integer> {

	@Override
	public List<User> findAll() {
		Connection con = DAOUtilities.getConnection();
		List<User> usrList = new ArrayList<User>();
		String sql = "select * from cduser;"; 
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				User tempUser = new User(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5));
				usrList.add(tempUser);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usrList;
	}

	@Override
	public User findById(Integer i) {
		Connection con = DAOUtilities.getConnection();
		User rU = new User();
		String sql = "select * from cduser where user_id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, i);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				rU.setUserId(rs.getInt(1));
				rU.setEmail(rs.getString("email"));
				rU.setUserName(rs.getString("username"));
				rU.setPassword(rs.getString("cd_password"));
				rU.setUserLevel(rs.getInt("user_level"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rU;
	}
	public User findByUsername(String n) {
		Connection con = DAOUtilities.getConnection();
		User rU = new User();
		String sql = "select * from cduser where username=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, n);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				rU.setEmail(rs.getString("email"));
				rU.setUserName(rs.getString("username"));
				rU.setPassword(rs.getString("cd_password"));
				rU.setUserLevel(rs.getInt("user_level"));
				rU.setUserId(rs.getInt("user_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rU;
		
	}
	public User findByEmail(String n) {
		Connection con = DAOUtilities.getConnection();
		User rU = new User();
		String sql = "select * from cduser where email=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, n);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				rU.setEmail(rs.getString("email"));
				rU.setUserName(rs.getString("username"));
				rU.setPassword(rs.getString("cd_password"));
				rU.setUserLevel(rs.getInt("user_level"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rU;
		
	}

	@Override
	public User update(User t) {
		
		return null;
	}

	@Override
	public User create(User t) {
		Connection con = DAOUtilities.getConnection();
	
		String sql = "insert into cduser (user_level, email, username, cd_password) values (?,?,?,?);";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,t.getUserLevel());
			stmt.setString(2,t.getEmail());
			stmt.setString(3, t.getUserName());
			stmt.setString(4, t.getPassword());
			stmt.executeUpdate();
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public int delete(Integer i) {
		
		return 0;
	}

}
