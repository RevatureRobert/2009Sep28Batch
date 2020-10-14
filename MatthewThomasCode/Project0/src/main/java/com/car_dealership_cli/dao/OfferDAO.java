package com.car_dealership_cli.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.car_dealership_cli.controller.UserController;
import com.car_dealership_cli.model.Offer;
import com.car_dealership_cli.repo.DAOContract;
import com.car_dealership_cli.repo.DAOUtilities;

public class OfferDAO implements DAOContract<Offer, Integer> {

	
	public List<Offer> findByCarId(int i) {
			Connection con = DAOUtilities.getConnection();
			CarDAO cd = new CarDAO();
			UserDAO ud = new UserDAO();
			List<Offer> offerList = new ArrayList<Offer>();
			String sql = "select * from offer where car_id = ?;"; 
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, i);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					Offer tempUser = new Offer(rs.getInt(1),cd.findById((rs.getInt(2))),rs.getDouble(3), ud.findById(rs.getInt(4)));
					offerList.add(tempUser);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return offerList;
	
	}

	@Override
	public Offer findById(Integer i) {
		Connection con = DAOUtilities.getConnection();
		Offer rU = null;
		String sql = "select * from offer where offer_id=?";
		UserDAO ud = new UserDAO();
		CarDAO cd = new CarDAO();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, i);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				rU = new Offer(rs.getInt(1),cd.findById((rs.getInt(2))),rs.getDouble(3), ud.findById(rs.getInt(4)));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rU;
	}

	@Override
	public Offer update(Offer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offer create(Offer t) {
		Connection con = DAOUtilities.getConnection();
		
		String sql = "insert into offer (car_id, offer, user_id) values (?,?,?);";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,t.getCar().getCarId());
			stmt.setDouble(2,t.getOffer());
			stmt.setInt(3, UserController.getUser().getUserId());
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Please enter a valid Car ID and  Offer ammount (XXXXX.xx) next time");
		e.printStackTrace();
		}	
		return null;
	}

	@Override
	public int delete(Integer i) {
		Connection con = DAOUtilities.getConnection();
		int result = 0;
		String sql = "call cd.remove_offers(?);";
		try {
			CallableStatement stmt = con.prepareCall(sql);
			stmt.setInt(1, i);
			result = stmt.executeUpdate();				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Offer> findAll() {
		Connection con = DAOUtilities.getConnection();
		CarDAO cd = new CarDAO();
		UserDAO ud = new UserDAO();
		List<Offer> offerList = new ArrayList<Offer>();
		String sql = "select * from offer order by car_id;"; 
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
		
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Offer tempUser = new Offer(rs.getInt(1),cd.findById((rs.getInt(2))),rs.getDouble(3), ud.findById(rs.getInt(4)));
				offerList.add(tempUser);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return offerList;

	
	}

}
