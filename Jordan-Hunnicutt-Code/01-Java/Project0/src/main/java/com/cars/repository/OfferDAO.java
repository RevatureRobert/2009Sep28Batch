package com.cars.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.cars.config.PTConnUtil;
import com.cars.model.Offer;

public class OfferDAO implements RepositoryFunctions<Offer, Integer>{

	@Override
	public List<Offer> findAll() {
		List<Offer> offers = new LinkedList<>(); //prevent nullpointerexceptions
		try(Connection conn = PTConnUtil.getInstance().getConnection()){
			String sql = "select * from offer where carId > ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 0);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				offers.add(new Offer(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDate(5),rs.getDate(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return offers;
	}

	public List<Offer> findSome(int i){
		List<Offer> offers = new ArrayList<>(); //this prevents nullpointerexceptions by passing an empty list at the very least
		try(Connection conn = PTConnUtil.getInstance().getConnection()){ //connection will auto close after try block ends
			String sql = "select * from offer where (carId, status) = (?,'submitted')";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				offers.add(new Offer(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDate(5),rs.getDate(6)));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offers;
	}
	
	@Override
	public Offer findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Offer findSome(Integer carId, Integer userId) {
		return null;
	}
	
	@Override
	public Offer update(Offer t) {
		
		try(Connection conn = PTConnUtil.getInstance().getConnection()){
			String sql = "update offer set (status, appOrRejDate) = (?,?) where (amount, carId, userId) = (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getStatus());
			ps.setDate(2, t.getAppOrRejDate());
			ps.setInt(3, t.getAmount());
			ps.setInt(4, t.getCarId());
			ps.setInt(5, t.getUserId());
			int updated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return t;
	}

	public boolean autoUpdate(int i) {
		//this function activates a prepared statement in sql
		
		try(Connection conn = PTConnUtil.getInstance().getConnection()){
			String sql = "call auto_reject(?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, i);
			cs.setDate(2, Date.valueOf(LocalDate.now()));
			boolean updated = cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@Override
	public Offer create(Offer t) {
		try(Connection conn = PTConnUtil.getInstance().getConnection()){
			String sql = "insert into offer (amount, carId, userId, status, addDate) values (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getAmount());
			ps.setInt(2, t.getCarId());
			ps.setInt(3, t.getUserId());
			ps.setString(4, t.getStatus());
			ps.setDate(5, t.getAddDate());
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
