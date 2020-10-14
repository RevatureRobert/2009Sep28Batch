package com.project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.config.PlainTextConnectionUtil;

public class DAOUtil {

	public void callClearOffers(int x) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql="CALL \"carDealership\".clear_offers(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, x);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
