package com.revature.repo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.config.FileConnectionUtil;

public class DaoUtil {
	public void callRemovePending() {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql="call remove_pending()";
			CallableStatement cs = conn.prepareCall(sql);
			cs.execute();
			cs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}		
	}
}
