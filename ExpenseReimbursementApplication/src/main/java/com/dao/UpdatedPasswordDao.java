package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.ConnectionUtil;
import com.util.MyHash;

public class UpdatedPasswordDao 
{
	
	public void updatePassword(String userid, String password)
	{
		String sql = "update \"Project1\".users set password = ? where username = ?;";
		
		
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) 
		{
			ps.setString(1, password);
			ps.setString(2, userid);
			
			int rs = ps.executeUpdate();	
			
		}
		catch(SQLException e)
		{
			
			System.out.println("Could not update the users password. Exception occurred");
			e.printStackTrace();
		}
	}
}


