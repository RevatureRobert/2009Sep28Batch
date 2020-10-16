package com.revature.repo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.revature.config.PlainTextConnectionUtil;

public class DaoUtil {
	
	public String callConcatSum(int x, int y, String s) {
		String result = null;
		
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "{ ? = call public.concat_sum(?, ?, ?) }";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2,  x);
			cs.setInt(3,  y);
			cs.setString(4,  s);
			cs.execute();
			
			result = cs.getString(1);
			
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String prepareConcatSum(int x, int y, String s) {
		String result = null;
		
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "select * from public.concat_sum(?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, x);
			ps.setInt(2, y);
			ps.setString(3, s);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
				result = rs.getString(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
