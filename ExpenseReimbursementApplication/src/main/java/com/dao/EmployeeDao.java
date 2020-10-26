package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.Employee;
import com.util.ConnectionUtil;

public class EmployeeDao implements DaoContract<Employee, Integer>
{

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Employee user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int create(Employee user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
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

}
