package com.cardealership.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.cardealership.config.PlainTextConnectionUtil;
import com.cardealership.model.Admin;
import com.cardealership.model.Customer;
import com.cardealership.model.Employee;
import com.cardealership.model.Offers;
import com.cardealership.model.Unsold_Car;

public class DealershipDao {
	public void viewLot(Admin t) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "Select * from unsold_car where dealership_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, t.getDealershipId());
			ResultSet rs = s.executeQuery();
			
			
			while(rs.next()) {
				Unsold_Car car = new Unsold_Car(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				System.out.println(car.toString());
			}
			s.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void viewLot(Employee t) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "Select * from unsold_car where dealership_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, t.getDealershipId());
			ResultSet rs = s.executeQuery();
			
			
			while(rs.next()) {
				Unsold_Car car = new Unsold_Car(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				System.out.println(car.toString());
			}
			s.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void viewLot(int dealershipId) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "Select * from unsold_car where dealership_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, dealershipId);
			ResultSet rs = s.executeQuery();
			
			
			while(rs.next()) {
				Unsold_Car car = new Unsold_Car(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				System.out.println(car.toString());
			}
			s.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean addCar(int dealershipId, String name, int asking_price) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "insert into unsold_car (unsold_car_name, unsold_car_asking_price, dealership_id) values " + 
					"(?, ?, ?)";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, name);
			s.setInt(2, asking_price);
			s.setInt(3, dealershipId);
			s.executeUpdate();
			
			s.close();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean removeCar(int carId) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "delete from unsold_car where unsold_car_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, carId);
			s.executeUpdate();
			
			s.close();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			}

		return false;
	}
	public boolean updateCar(int carId, String carName, int askingPrice) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "update unsold_car set unsold_car_name = ?, unsold_car_asking_price = ? where unsold_car_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, carName);
			s.setInt(2, askingPrice);
			s.setInt(3, carId);
			s.executeUpdate();
			
			s.close();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Offers> getOffers(int carId){
		List<Offers> offer = new LinkedList<>();
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "select * from offer where car_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, carId);
			ResultSet rs = s.executeQuery();
			while(rs.next()) {
				offer.add(new Offers(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
			rs.close();
			s.close();
			return offer;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}
	public boolean acceptOffer(int carId, int userId) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			//select the offer
			String sqlSelectOffer = "select * from offer where car_id = ? and user_id = ?";
			PreparedStatement sso = conn.prepareStatement(sqlSelectOffer);
			sso.setInt(1, carId);
			sso.setInt(2, userId);
			ResultSet rsso = sso.executeQuery();
			
			//move car to sold
			String sqlUnsoldCar = "select * from unsold_car where car_id = ?";
			PreparedStatement suc = conn.prepareStatement(sqlUnsoldCar);
			suc.setInt(1, carId);
			ResultSet rsuc = suc.executeQuery();
			rsuc.next();
			
			String sqlSoldCar = "insert into sold_car (sold_car_name, owner_user_id) values (?,?)";
			PreparedStatement ssc = conn.prepareStatement(sqlSoldCar);
			ssc.setString(1, rsuc.getString(2));
			ssc.setInt(2, userId);
			ssc.executeUpdate();
			
			//add balance to user
			String sqlUpdateUser = "update customer set customer_balance = ? where user_id = ?";
			PreparedStatement suu = conn.prepareStatement(sqlUpdateUser);
			suu.setInt(1, rsso.getInt(3));
			suu.setInt(2, userId);
			suu.executeUpdate();
			
			//reject all offers and delete unsold_car
			rejectOffers(carId);
			String sqlDeleteUSC = "";
			
			
			//log4j
		}catch(SQLException e) {
			
		}
		return false;
	}
	public boolean rejectOffer(int carId, int userId) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "delete from offer where car_id = ? and user_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, carId);
			s.setInt(2, userId);
			s.executeUpdate();
			s.close();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean rejectOffers(int carId) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "delete from offer where car_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, carId);
			s.executeUpdate();
			s.close();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}



























