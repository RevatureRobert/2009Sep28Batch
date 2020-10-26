package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.servlet.LoginSuccessfulServlet;
import com.util.ConnectionUtil;

public class LoginValidationDao 
{
	LoginSuccessfulServlet lss = new LoginSuccessfulServlet();
	
	public String loginValidation(String username, String password)
	{
	
		String sql = "select users.first_name, users.last_name from \"Project1\".users where username = ? and password = ?;";
		
		String firstname = "";
		String lastname = "";
		
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) 
		{
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				firstname = rs.getString(1);
				lastname = rs.getString(2);
			}
		}
		catch(SQLException e)
		{
			
			return firstname + " " + lastname;
			
		}
		return firstname + " " + lastname;
	}
	
	public int validateUserRoleID(String username)
	{
		String sql = "select users.user_role_id from \"Project1\".users where username= ?;";
		
		int userroleid = 0;
		
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) 
		{
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				userroleid = rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			return userroleid;
			
		}
		return userroleid;
		
	}
}
