package com.cars.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cars.config.PTConnUtil;
import com.cars.model.Payment;

public class PaymentDAO implements RepositoryFunctions<Payment, Integer>{

	@Override
	public List<Payment> findAll() {
		List<Payment> payments = new ArrayList<>(); //this prevents nullpointerexceptions by passing an empty list at the very least
		try(Connection conn = PTConnUtil.getInstance().getConnection()){ //connection will auto close after try block ends
			String sql = "select * from payment where carId > ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, 0);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				payments.add(new Payment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5)));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return payments; 
	}
	
	public List<Payment> findSome(int i){
		List<Payment> payments = new ArrayList<>(); //this prevents nullpointerexceptions by passing an empty list at the very least
		try(Connection conn = PTConnUtil.getInstance().getConnection()){ //connection will auto close after try block ends
			String sql = "select * from payment where userId = ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				payments.add(new Payment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5)));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return payments; 
	}
	
	@Override
	public Payment findById(Integer i) {
		Payment p = null;
		
		try(Connection conn = PTConnUtil.getInstance().getConnection()){
			String sql = "select * from payment where carId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				p = new Payment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	public Payment findByTwoIds(Integer carId, Integer userId) {
		Payment p = null;
		
		try(Connection conn = PTConnUtil.getInstance().getConnection()){
			String sql = "select * from payment where (carId, userId) = (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, carId);
			ps.setInt(2, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				p = new Payment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	@Override
	public Payment update(Payment t) {
		
		try(Connection conn = PTConnUtil.getInstance().getConnection()){
			String sql = "update payment set num_of = ? where carId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getNumOf());
			ps.setInt(2, t.getCarId());
			int updated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return t;
	}

	@Override
	public Payment create(Payment t) {
		try(Connection conn = PTConnUtil.getInstance().getConnection()){
			String sql = "insert into payment (amount, num_of, carId, userId, purchaseDate) values (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getAmount());
			ps.setInt(2, t.getNumOf());
			ps.setInt(3, t.getCarId());
			ps.setInt(4, t.getUserId());
			ps.setDate(5, t.getPurchaseDate());
			int inserted = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		return t;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		
		return 0;
	}

}
