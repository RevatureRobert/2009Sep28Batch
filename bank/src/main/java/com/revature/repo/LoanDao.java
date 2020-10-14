package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.config.FileConnectionUtil;
import com.revature.model.Loan;

public class LoanDao implements DaoContract<Loan, Integer>{
	private CustomerDao cd;
	
	public List<Loan> findAll() {
		List<Loan> loans = new LinkedList<>();
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from loans";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				loans.add(new Loan(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6), cd.findById(7)));
			}
			rs.close();
			s.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return loans;
	}

	public Loan findById(Integer i) {
		Loan l = null;
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from accounts where account_id = ?"; //this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				l = new Loan(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6), null);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	public Loan update(Loan t) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "update loans set loan_id = ?, principal = ?, interest = ?, accrued_interest = ?, term_months = ?, customer_id = ? where loan_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getLoanID());
			ps.setFloat(2, t.getPrincipal());
			ps.setFloat(3, t.getInterest());
			ps.setFloat(4, t.getAccruedInterest());
			ps.setInt(5, t.getTermMonths());
			ps.setInt(6, t.getCustomerID().getCustomerID());
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	public Loan create(Loan t) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into loans (loan_id, principal, interest, accrued_interest, term_months, customer_id) values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getLoanID());
			ps.setFloat(2, t.getPrincipal());
			ps.setFloat(3, t.getInterest());
			ps.setFloat(4,  t.getAccruedInterest());
			ps.setInt(5, t.getTermMonths());
			ps.setInt(6, t.getCustomerID().getCustomerID());
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	public int delete(Integer i) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "delete from loans where loan_id = ?";
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
