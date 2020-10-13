package com.project0.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project0.config.EnvironmentConnectionUtil;
import com.project0.models.Customer;
import com.project0.models.Payment;

public class PaymentDao implements DaoContract<Payment,Integer>{

	@Override
	public List<Payment> findAll() {
		List<Payment> payments = new ArrayList<Payment>();
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from payments";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int user = rs.getInt(1);
				int car = rs.getInt(2);
				int monthsLeft = rs.getInt(3);
				double amountLeft = rs.getDouble(4);
				double perMonth = rs.getDouble(5);
				double original = rs.getDouble(6);
				payments.add(new Payment(user,car,amountLeft, monthsLeft,original,perMonth)); 
			}
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payments;
	}

	@Override
	public Payment findById(Integer car) {
		Payment p = null;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from payments where carId = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, car);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int user = rs.getInt(1);
				int carr = rs.getInt(2);
				int monthsLeft = rs.getInt(3);
				double amountLeft = rs.getDouble(4);
				double perMonth = rs.getDouble(5);
				double original = rs.getDouble(6);
				p = new Payment(user,carr,amountLeft, monthsLeft,original,perMonth); 
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Payment update(Payment t) {
		Payment p = t;
		int carID = p.getCarId();
		int monthsLeft = p.getMonthsLeft();
		double amountLeft = p.amountLeft();
		double perMonth = p.perMonth();
		double original = p.getOriginal();
		
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "update payments set MonthsLeft = ?, AmountLeft = ?, PerMonth = ?, Original = ?  where carId = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, monthsLeft);
			ps.setDouble(2, amountLeft);
			ps.setDouble(3, perMonth);
			ps.setDouble(4, original);
			ps.setInt(5, carID);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Payment create(Payment t) {
		Payment x = t;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "insert into payments values (?,?,?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, x.getUserId());
			ps.setDouble(2, x.getCarId());
			ps.setInt(3, x.getMonthsLeft());
			ps.setDouble(4, x.amountLeft());
			ps.setDouble(5,x.perMonth()) ;
			ps.setDouble(6, x.getOriginal());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
		
	}

	@Override
	public int delete(Integer car) {
		int result = 0;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "delete from payments where carId = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, car);
			result = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Payment> findByUser(int userID) {
		List<Payment> payments = new ArrayList<Payment>();
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from payments where OwnerID= ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,userID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int user = rs.getInt(1);
				int car = rs.getInt(2);
				int monthsLeft = rs.getInt(3);
				double amountLeft = rs.getDouble(4);
				double perMonth = rs.getDouble(5);
				double original = rs.getDouble(6);
				payments.add(new Payment(user,car,amountLeft, monthsLeft,original,perMonth)); 
			}
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payments;
	}
	
	public ArrayList<Integer> getUserCars(int userID) {
		ArrayList<Integer> carids = new ArrayList<Integer>();;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select CarID from payments where OwnerID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				carids.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return carids;
	}

}
