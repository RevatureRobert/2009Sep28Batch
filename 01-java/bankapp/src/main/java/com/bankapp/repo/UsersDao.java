package com.bankapp.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bankapp.config.PlainTextConnectionUtil;
import com.bankapp.model.Users;

public class UsersDao implements DaoContract<Users, String>{
	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Users findById(String i) {
		Users u = null;
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "select * from users where username = ?";		// for prepared statements
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getBoolean(5), rs.getBoolean(6), rs.getBoolean(7), rs.getDouble(8), rs.getBoolean(9), rs.getDouble(10));//adjust for table
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public Users update(Users t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users create(Users t) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "insert into users (username, user_password, email) values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getEmail());
			ps.setString(3, t.getUser_password());
			int updated = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	@Override
	public int delete(String i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
