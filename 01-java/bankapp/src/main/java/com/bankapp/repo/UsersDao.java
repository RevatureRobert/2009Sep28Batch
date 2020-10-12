package com.bankapp.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bankapp.model.Users;
import com.revature.config.PlainTextConnectionUtil;
import com.revature.model.Circus;

public class UsersDao {
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
				u = new Users(rs.getString(1), rs.getString(2), rs.getBoolean(3), null);//adjust for table
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Users update(Users t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users create(Circus t) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "insert into users values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setString(2, t.getRingleader());
			ps.setBoolean(3, t.isEntertaining());
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
