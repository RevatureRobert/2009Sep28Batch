package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.model.Employee;
import com.util.ConnectionUtil;

public class EmployeeDao 
{	
	public int findUserIDByUserName(String username)
	{
		String sql = "select users.users_id from \"Project1\".users where username = ?;";	
		int users_id = 0;	
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) 
		{
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				users_id = rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			System.out.println("An exception occurred");
			e.printStackTrace();
			return users_id;		
		}
		return users_id;
	}	
	
	public int findUserIDByFullName(String fullname)
	{
		String firstname ="";
		String lastname ="";
		int hit = 0;
		
		for(int i = 0; i <fullname.length(); i++)
		{
			if(hit == 0)
			{
				if(fullname.charAt(i) == ' ')
				{
					hit++;
					continue;
				}
				firstname += fullname.charAt(i);
			}
			
			if(hit == 1)
			{
				lastname += fullname.charAt(i);
			}
		}
		
		int userid = 0;
		String sql = "select users.users_id from \"Project1\".users where first_name = ? and last_name = ?;";
		
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) 
		{
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				userid = rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			System.out.println("An exception occurred");
			e.printStackTrace();
			return userid;		
		}
		return userid;
		
	}
	public String findfullNamebyUserID(int userid)
	{
String sql = "select users.first_name, users.last_name from \"Project1\".users where users_id = ?;";
		
		String firstname = "";
		String lastname = "";
		
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) 
		{
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				firstname = rs.getString(1);
				lastname = rs.getString(2);
			}
		}
		catch(SQLException e)
		{
			System.out.println("An exception occurred");
			e.printStackTrace();
			return firstname;		
		}
		return firstname + " " + lastname;
	}	
	public int confirmAddedReimbursement()
	{
		String sql = "insert into \"Project1\".reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id)\n"
				+ "values (?, ?, ?, ?, ?, ?);";
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) 
		{
			ps.setFloat(1, 1);
			ps.setTimestamp(2, ts);
			ps.setString(3, "");
			ps.setInt(4, 1);
			ps.setInt(5, 1);
			ps.setInt(6, 1);
			int rs = ps.executeUpdate();		
		}catch(SQLException e)
		{
			System.out.println("can't add reimbursement to database");
			e.printStackTrace();
		}
		
		return 1;
	}

}
