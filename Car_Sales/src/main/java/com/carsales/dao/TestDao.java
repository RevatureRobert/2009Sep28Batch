package com.carsales.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.carsales.model.*;
import com.carsales.util.*;

public class TestDao {
	
	
	public TestDao() {
		super();
	}
	
	public List<Testcl> findAll(){
		List<Testcl> tests = new LinkedList<>();
		try(Connection conn = ConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from carlot_schema.testing";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				tests.add(new Testcl(rs.getInt(1), rs.getString(2), rs.getBoolean(3)));
			}
			rs.close();
			s.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return tests;
	}
	

}
