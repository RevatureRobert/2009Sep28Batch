package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.config.PlainTextConnectionUtil;
import com.revature.model.Circus;

public class CircusDao implements DaoContract<Circus, String>{

	@Override
	public List<Circus> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Circus findById(String i) {
		Circus c = null;
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "select * from circus where name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c= new Circus(rs.getString(1), rs.getString(2), rs.getBoolean(3),null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Circus update(Circus t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Circus create(Circus t) {
		Circus c = null;
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "insert into circus values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,t.getName());
			ps.setString(2,t.getRingleader());
			ps.setBoolean(3, t.isEntertaining());
			int updated  = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
