package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.config.FileConnectionUtil;
import com.revature.model.Transaction;

public class TransactionDao implements DaoContract<Transaction, Integer>{
	private CustomerDao cd = new CustomerDao();
	
	public List<Transaction> findAll() {
		List<Transaction> transactions = new LinkedList<>();
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from transactions";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				transactions.add(new Transaction(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), cd.findById(6)));
			}
			rs.close();
			s.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}

	public Transaction findById(Integer i) {
		Transaction t = null;
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from transactions where transaction_id = ?"; //this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t = new Transaction(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), cd.findById(7));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	public Transaction update(Transaction t) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "update transaction set transaction_type = ?, account_id_from = ?, account_id_to = ?, amount = ?, customer_id = ? where transaction_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
	//		ps.setInt(1, t.getTransactionID());
			ps.setString(2,  t.getTransactionType());
			ps.setInt(3, t.getAccountIDFrom());
			ps.setInt(4,  t.getAccountIDTo());
			ps.setFloat(5, t.getAmount());
			ps.setInt(6, t.getCustomerID().getCustomerID());
			ps.setInt(1, t.getTransactionID());
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	//TODO: when account_id_from and to are -1, insert null when creating row in database
	public Transaction create(Transaction t) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into transactions (transaction_type, account_id_from, account_id_to, amount, customer_id) values (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1, t.getTransactionID());
			ps.setString(1, t.getTransactionType());
			ps.setInt(2,  t.getAccountIDFrom());
			ps.setInt(3, t.getAccountIDTo());
			ps.setFloat(4, t.getAmount());
			ps.setInt(5, t.getCustomerID().getCustomerID());
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	public int delete(Integer i) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "delete from transactions where transaction_id = ?";
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
