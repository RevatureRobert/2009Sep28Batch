package com.cardealership.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.cardealership.config.PlainTextConnectionUtil;
import com.cardealership.model.User;
import com.cardealership.model.UserType;

public class UserDao implements DaoContract<User, Integer>{
	
	public User login(String username, String password) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
		String sql = "select * from dealership_user where user_username = ? and user_password = ?";
		PreparedStatement s = conn.prepareStatement(sql);
		s.setString(1, username);
		s.setString(2, password);
		ResultSet rs = s.executeQuery();
		rs.next();
		UserType userType = UserType.valueOf(rs.getString(4));
		User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), userType, rs.getString(5), rs.getString(6), rs.getString(7));
		return user;		
		
		}catch(SQLException e) {
//			e.printStackTrace();
			return null;
		}
	}
	
	
	/*
	 * methods below are redundant in this Dao and should not be used
	 * 
	 * */
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	public User create(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
