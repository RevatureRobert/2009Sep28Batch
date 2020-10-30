package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.model.FinanceManager;
import com.util.ConnectionUtil;

public class FinanceManagerDao 
{
	public List<FinanceManager> findAll() {
		
		List <FinanceManager> partners = new LinkedList<>();
		
		String sql = "select * from users where user_role_id = 2";
		
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				partners.add(new FinanceManager(rs.getInt("users_id"), rs.getString("username"), rs.getString("password"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getInt("user_role_id")));
			}
			rs.close();
			ps.close();
		} 
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return partners;		
	}
	public FinanceManager findById(int id) 
	{
		FinanceManager fm = null;
		
		String sql = "select * from users where users_id = ?";
		
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			fm = new FinanceManager(rs.getInt("users_id"), rs.getString("username"), rs.getString("password"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getInt("user_role_id"));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return fm;
	}
}
