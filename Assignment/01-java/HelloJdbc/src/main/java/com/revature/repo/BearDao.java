package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.config.EnvironmentConnectionUtil;
import com.revature.config.PlainTextConnectionUtil;
import com.revature.model.Bear;

public class BearDao implements DaoContract<Bear, Integer>{
	private CircusDao cd;
	
	public BearDao(CircusDao cd) {
		super();
		this.cd = cd;
	}

	/**
	 * this method will be using a Statement. It is referred to as
	 * a simple statement. In general, we want to stay away from 
	 * simple statements and use prepared statements
	 * 
	 * The simple statement does not have a way of sanitizing input, also it is less performant than the prepared statement. 
	 */
	@Override
	public List<Bear> findAll() {
		List<Bear> bears = new LinkedList<>();
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			Statement s = conn.createStatement();
			String sql = "select * from bear";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				bears.add(new Bear(rs.getInt(1), rs.getString(2), rs.getBoolean(3), null));
			}
			rs.close();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bears;
	}

	
	/**
	 * this will use a prepared statement
	 * 
	 * A prepared statement will sanitize the input and precompile the statement
	 * before sending it to be executed by the db. 
	 */
	@Override
	public Bear findById(Integer i) {
		Bear b = null;
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			//String sql = "select * from bear where tag_id = " +i;  this will cause sql injection ** badd
			String sql = "select * from bear where tag_id = ?"; // this will sanitize the input. 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				b = new Bear(rs.getInt(1), rs.getString(2), rs.getBoolean(3), cd.findById(rs.getString(4)));
			}
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public Bear update(Bear t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bear create(Bear t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
