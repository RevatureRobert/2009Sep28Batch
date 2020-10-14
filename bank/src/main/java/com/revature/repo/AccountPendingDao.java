package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.config.FileConnectionUtil;
import com.revature.model.AccountPending;

public class AccountPendingDao implements DaoContract<AccountPending, Integer>{
	private CustomerDao cd = new CustomerDao();
	
	public List<AccountPending> findAll() {
		List<AccountPending> accountsPending = new LinkedList<>();
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from accounts_pending";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				accountsPending.add(new AccountPending(rs.getInt(1), rs.getString(2), cd.findById(rs.getInt(3))));
			}
			rs.close();
			s.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return accountsPending;
	}

	public AccountPending findById(Integer i) {
		AccountPending a = null;
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from accounts_pending where accounts_pending_id = ?"; //this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a = new AccountPending(rs.getInt(1), rs.getString(2), cd.findById(rs.getInt(3)));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public AccountPending update(AccountPending t) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "update accounts_pending set accounts_pending_id = ?, acount_type = ?, customer_id = ? where account_pending_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getAccountPendingID());
			ps.setString(2, t.getAccountType());
			ps.setInt(3, t.getCustomerID().getCustomerID());
			ps.setInt(4, t.getAccountPendingID());
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	public AccountPending create(AccountPending t) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into accounts_pending (account_type, customer_id) values (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getAccountType());
			ps.setInt(2, t.getCustomerID().getCustomerID());
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	public int delete(Integer i) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "delete from accounts_pending where accounts_pending_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return - 1;
		}
		return i;
	}

}
