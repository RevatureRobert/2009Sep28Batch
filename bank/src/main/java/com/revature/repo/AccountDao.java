package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.config.FileConnectionUtil;
import com.revature.model.Account;

public class AccountDao implements DaoContract<Account, Integer> {
	private CustomerDao cd = new CustomerDao();
	
	public AccountDao(CustomerDao cd) {
		super();
		this.cd = cd;
	}
	
	public AccountDao() {
		super();
	}
	
	public List<Account> findAll() {
		List<Account> accounts = new LinkedList<>();
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from accounts";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				accounts.add(new Account(rs.getInt(1), rs.getString(2), rs.getFloat(3), cd.findById(rs.getInt(4))));
			}
			rs.close();
			s.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	public Account findById(Integer i) {
		Account a = null;
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from accounts where account_id = ?"; //this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a = new Account(rs.getInt(1), rs.getString(2), rs.getFloat(3), cd.findById(rs.getInt(4)));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public List<Account> findAccountsByCustomerId(Integer i) {
		List<Account> accounts = new LinkedList<>();
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from accounts where customer_id = ?"; //this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			System.out.println("Printing out accounts for customer id:" + i);
			while(rs.next()) {
				//Account newAccount = new Account(rs.getInt(1), rs.getString(2), rs.getFloat(3), cd.findById(rs.getInt(4)));
				//System.out.println(newAccount.toString());
				//accounts.add(newAccount);
				accounts.add(new Account(rs.getInt(1), rs.getString(2), rs.getFloat(3), cd.findById(rs.getInt(4))));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	public Account update(Account t) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "update accounts set account_id = ?, account_type = ?, balance = ?, customer_id = ? where account_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getAccountID());
			ps.setString(2, t.getAccountType());
			ps.setFloat(3,  t.getBalance());
			ps.setInt(4, t.getCustomerID().getCustomerID());
			ps.setInt(5, t.getAccountID());
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	public Account create(Account t) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into accounts (account_id, account_type, balance, customer_id) values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getAccountID());
			ps.setString(2, t.getAccountType());
			ps.setFloat(3,  t.getBalance());
			ps.setInt(4, t.getCustomerID().getCustomerID());
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	public int delete(Integer i) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "delete from accounts where account_id = ?";
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
