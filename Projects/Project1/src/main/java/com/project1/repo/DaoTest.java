package com.project1.repo;

import java.io.FileInputStream;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

public class DaoTest {
	
	public static void main(String[] args) {
		System.out.println("wow");
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("Is it same?: " + ldt);
		Instant instant = Instant.now();
		Timestamp ts = Timestamp.from(instant);
		System.out.println(ts);
		LocalDateTime ret = null;
		
		
//		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
//			String sql = "insert into time values (?)";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setObject(1, ldt);
//			ps.executeUpdate();
//			ps.close();
//			sql = "select * from time;";
//			ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				ret = ((Timestamp) rs.getObject(1)).toLocalDateTime();
//				System.out.println("Got back: " + ret.toString());
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
