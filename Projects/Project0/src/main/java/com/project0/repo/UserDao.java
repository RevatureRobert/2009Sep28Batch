package com.project0.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project0.config.EnvironmentConnectionUtil;
import com.project0.models.Customer;
import com.project0.models.Employee;
import com.project0.models.User;

import jdk.internal.org.jline.utils.Log;

public class UserDao implements DaoContract<User,Integer>{
	final static Logger log = Logger.getLogger(UserDao.class);
	public UserDao() {
		super();
	}
	
	//method to check whether login is valid
		public int checkLogin(String username, String password) {
			try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()) {
				String sql = "select * from users where Username =?;";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					String check = rs.getString("Password");
					if(check.equals(password)) {
						boolean isEmployee = rs.getBoolean("Employee");
						rs.close();
						ps.close();
						if(isEmployee) {
							//its an employee
							return 1;
						} else {return 0;} //it's a customer
					} else {
						rs.close();
						ps.close();
						log.info("password was incorrect");
						//password is incorrect
						return 2;
					}
				} else {
					//no such username
					log.info("username was incorrect");
					rs.close();
					ps.close();
					return 2;
				}
			} catch(SQLException e) {
				log.error("There was a sql exception:" + e);
				e.printStackTrace();
				return 2;
			}
			
		} //end of login method
		
	//method to check whether username is available
	public boolean checkUsername(String username) {
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()) {
			String sql = "select count(Username) from users where Username =?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int exists = rs.getInt(1);
				if(exists == 0) {
					rs.close();
					ps.close();
					return true;
				}
			}
			rs.close();
			ps.close();
			log.info("There was no matching username");
			return false;
		} catch(SQLException e) {
			log.error("There was an sql exception:" + e);
			e.printStackTrace();
			return false;
		}
	}//end of checkUsername method

	//method to enter a new customer
	public int registerCustomer(String username, String password){
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "insert into users (Username,Password,Employee) values (?, ?, false)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			int x = ps.executeUpdate();
			ps.close();
			return x;
		} catch(SQLException e) {
			log.error("There was an sql exception:" + e);
			e.printStackTrace();
			return 0;
		}
	}//end of registerCustomer method
	
	
//maybe later just call customer and employee dao. 
	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from users;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				boolean isEmployee = rs.getBoolean(4);
				if(isEmployee) {
					users.add(new Employee(id,username));
				} else {
					Customer c = new Customer(id,username);
					//c.setOwnedCars(CarDao get by owner id);
					users.add(new Customer(id,username));
				}
			}
		} catch (SQLException e) {
			log.error("There was an sql exception:" + e);
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User findById(Integer i) {
		User u = null;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from users where UserID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				boolean isEmployee = rs.getBoolean(4);
				if(isEmployee) {
					u = new Employee(id,username);
				} else {
					u = new Customer(id,username);
					//c.setOwnedCars(CarDao get by owner id);
				}
			}
		} catch (SQLException e) {
			log.error("There was an sql exception:" + e);
			e.printStackTrace();
		}
		return u;
	}

	//There is no reason this method would ever be used 
	@Override
	public User update(User t) {
		User u = null;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			
			
		} catch (SQLException e) {
			log.error("There was an sql exception:" + e);
			e.printStackTrace();
		}
		return u;
	}

	//this method will never be used either.
	@Override
	public User create(User t) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public int delete(Integer i) {
		int x = 0;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql ="delete from users where UserID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			x =  ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error("There was an sql exception:" + e);
			e.printStackTrace();
		}
		return x;
	}
	
}
