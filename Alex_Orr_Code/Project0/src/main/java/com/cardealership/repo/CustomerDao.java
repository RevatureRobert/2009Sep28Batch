package com.cardealership.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import com.cardealership.config.EnvironmentConnectionUtil;
import com.cardealership.config.PlainTextConnectionUtil;
import com.cardealership.model.Customer;
import com.cardealership.model.Offers;
import com.cardealership.model.Sold_Car;
import com.cardealership.model.User;
import com.cardealership.model.Admin;
import com.cardealership.model.UserType;

public class CustomerDao implements DaoContract<Customer, Integer> {

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new LinkedList<>();
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "select * from dealership_user where user_type ='customer'";
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet rs = s.executeQuery();

			while(rs.next()) {
				String sqlc = "select * from customer where user_id = ?";
				PreparedStatement sc = conn.prepareStatement(sqlc);
				sc.setInt(1, rs.getInt(1));
				ResultSet rsc =  sc.executeQuery();
				rsc.next();
				customers.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), UserType.customer,rs.getString(5),rs.getString(6),rs.getString(7), rsc.getInt(1)));

			}
			rs.close();
			s.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	//i is customer id
	@Override
	public Customer findById(Integer i) {
		Customer customer;
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "select * from customer where customer_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, i);
			ResultSet rs = s.executeQuery();
			rs.next();

			String sqlc = "select * from dealership_user where user_id = ?";
			PreparedStatement sc = conn.prepareStatement(sqlc);
			sc.setInt(1, rs.getInt(2));
			ResultSet rsc =  sc.executeQuery();
			rsc.next();
			customer = new Customer(rsc.getInt(1), rsc.getString(2), rsc.getString(3), UserType.customer,rsc.getString(5),rsc.getString(6),rsc.getString(7), rs.getInt(1));
			rs.close();
			s.close();
			rsc.close();
			sc.close();
			return customer;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Customer update(Customer t) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){

			String sql = "update dealership_user set user_username = ?, user_password = ?, user_type = ?, user_first_name = ?, user_last_name = ?, user_email = ? where user_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, t.getUserUserName());
			s.setString(2, t.getUserPassword());
			s.setString(3, t.getUserType()+"");
			s.setString(4, t.getUserFirstName());
			s.setString(5, t.getUserLastName() );
			s.setString(6, t.getUserEmail());
			s.setInt(7, t.getUserId());
			s.executeUpdate();
			String sqla = "update customer set customer_balance = ?, customer_monthly_payment = ? where customer_id = ?";
			PreparedStatement sa = conn.prepareStatement(sqla);
			sa.setInt(1, t.getBalance());
			sa.setInt(2, t.getMonthlyPayment());
			sa.setInt(3, t.getCustomerId());
			sa.executeUpdate();
			s.close();
			sa.close();
			return t;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Customer create(Customer t) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "insert into dealership_user (user_username, user_password, user_type, user_first_name, user_last_name, user_email) values "+ 
					"(?, ?, ?, 'customer', ?, ?)";
			String sqlc = "insert into customer (user_id, customer_balance, customer_monthly_payment) values (?, ?, ?)";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1,  t.getUserUserName());
			s.setString(2, t.getUserPassword());
			s.setString(3, t.getUserFirstName());
			s.setString(4, t.getUserLastName());
			s.setString(5, t.getUserEmail());
			s.executeUpdate();
			PreparedStatement sc = conn.prepareStatement(sqlc);
			sc.setInt(1, t.getUserId());
			s.setInt(2, t.getBalance());
			s.setInt(3, t.getMonthlyPayment());
			sc.executeUpdate(sqlc);
			s.close();
			sc.close();
			return t;
		}catch(SQLException e) {
			//			e.printStackTrace();
		}
		return null;
	}
	public Customer create(String userName, String password, String fname, String lname, String email) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){

			//creates user
			String sql = "insert into dealership_user (user_username, user_password, user_type, user_first_name, user_last_name, user_email) values "+
					"(?, ?, 'customer', ?, ?, ?)";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, userName);
			s.setString(2, password);
			//			s.setString(3,"customer");
			//			s.setObject(3, UserType.customer);
			s.setString(3, fname);
			s.setString(4, lname);
			s.setString(5, email);
			s.executeUpdate();

			//gets user id
			String sqlGetUserId = "select * from dealership_user where user_username = ?";
			PreparedStatement sgui = conn.prepareStatement(sqlGetUserId);
			sgui.setString(1, userName);
			sgui.execute();
			ResultSet rs = sgui.executeQuery();
			rs.next();

			//creates customer
			String sqlc = "insert into customer (user_id, customer_balance, customer_monthly_payment) values (?, 0, 0)";
			PreparedStatement sc = conn.prepareStatement(sqlc);
			sc.setInt(1,rs.getInt(1));
			sc.executeUpdate();


			String getCustId = "select customer_id from customer where user_id = ?";
			PreparedStatement sGetCustId = conn.prepareStatement(getCustId);
			sGetCustId.setInt(1, rs.getInt(1));
			ResultSet rsGetCustId = sGetCustId.executeQuery();
			rsGetCustId.next();
			Customer t = new Customer(rs.getInt(1), userName, password, UserType.customer, fname, lname, email, rsGetCustId.getInt(1));

			sGetCustId.close();
			rsGetCustId.close();
			s.close();
			sgui.close();
			rs.close();
			sc.close();

			return t;
		}catch(SQLException e) {
			//			e.printStackTrace();
			return null;
		}

	}
	//i is user id
	@Override
	public int delete(Integer i) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "delete from customer where user_id = ?";
			String sqlu = "delete from dealership_user where user_id = ?"; 
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, i);
			s.executeUpdate();
			PreparedStatement su = conn.prepareStatement(sqlu);
			su.setInt(1, i);
			su.executeUpdate();
			s.close();
			su.close();
			return 1;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public Customer getCustomer(String username) {
		Customer customer;
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "select * from dealership_user where user_username = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, username);
			ResultSet rs = s.executeQuery();
			rs.next();
			String sqla = "select * from customer where user_id = ?";
			PreparedStatement sa = conn.prepareStatement(sqla);
			sa.setInt(1, rs.getInt(1));
			ResultSet rsa = sa.executeQuery();
			rsa.next();

			customer = new Customer( rs.getInt(1),  rs.getString(2), rs.getString(3),UserType.customer, rs.getString(5), rs.getString(6), rs.getString(7), rsa.getInt(1));
			return customer;
		}catch(SQLException e) {

		}
		return null;
	}
	public List<Sold_Car> myCars(int userId){
		List<Sold_Car> cars = new LinkedList<>();
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "select * from sold_car where owner_user_id =?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, userId);
			ResultSet rs = s.executeQuery();
			while(rs.next()) {
				cars.add(new Sold_Car(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			rs.close();
			s.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}
	public boolean makeOffer(int carId, int offerAmount, Customer t) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "insert into offer (car_id, user_id, offer_amount) values (?,?,?)";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, carId);
			s.setInt(2, t.getUserId());
			s.setInt(3, offerAmount);
			s.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Offers> getOffers(Customer t){
		List<Offers> offer = new LinkedList<>();
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "select * from offer where user_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, t.getUserId());
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
	public boolean removeOffer(int carId, Customer t) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "delete from offer where car_id = ? and user_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, carId);
			s.setInt(2, t.getUserId());
			s.executeUpdate();
			s.close();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public int getBalance(Customer t) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "Select * from customer where user_id=?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, t.getUserId());
			ResultSet rs = s.executeQuery();
			rs.next();
			int bal = rs.getInt(3);

			s.close();
			rs.close();
			return bal;
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int makePayment(int amount, Customer t) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "Select * from customer where user_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, t.getUserId());
			ResultSet rs = s.executeQuery();
			rs.next();
			int bal = rs.getInt(3)-amount;
			String sqlUpdate = "update customer set customer_balance = ?  where user_id = ?";
			PreparedStatement su = conn.prepareStatement(sqlUpdate);
			su.setInt(1, bal);
			su.setInt(2, t.getUserId());
			su.executeUpdate();
			return bal;
		} catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
}
