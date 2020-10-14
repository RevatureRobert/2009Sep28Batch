package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.config.FileConnectionUtil;
import com.revature.model.LoanPending;

public class LoanPendingDao implements DaoContract<LoanPending, Integer>{
	private CustomerDao cd;
	
	public List<LoanPending> findAll() {
		List<LoanPending> loansPending = new LinkedList<>();
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from loans_pending";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				loansPending.add(new LoanPending(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getInt(4), rs.getInt(5), cd.findById(6)));
			}
			rs.close();
			s.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return loansPending;
	}

	public LoanPending findById(Integer i) {
		LoanPending lp = null;
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from loans_pending where loan_pending_id = ?"; //this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				lp = new LoanPending(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getInt(4), rs.getInt(5), cd.findById(6));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lp;
	}

	public LoanPending update(LoanPending t) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "update loans_pending set loan_pending_id = ?, principal = ?, interest = ?, term_months= ?, credit_score = ? where loan_pending_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getCreditScore());
			ps.setFloat(2, t.getPrincipal());
			ps.setFloat(3,  t.getInterest());
			ps.setInt(4, t.getTermMonths());
			ps.setInt(5, t.getCreditScore());
			ps.setInt(6,  t.getCustomerID().getCustomerID());
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	public LoanPending create(LoanPending t) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into loans_pending (loan_pending_id, principal, interest, term_months, credit_score, customer_id) values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getLoanPendingID());
			ps.setFloat(2, t.getPrincipal());
			ps.setFloat(3,  t.getInterest());
			ps.setInt(4, t.getTermMonths());
			ps.setInt(5, t.getCreditScore());
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
			String sql = "delete from loans_pending where loan_pending_id = ?";
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
