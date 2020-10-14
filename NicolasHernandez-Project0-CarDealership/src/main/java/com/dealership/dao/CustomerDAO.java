package com.dealership.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

import com.dealership.frontend.Utilities;
import com.dealership.pojos.Car;
import com.dealership.pojos.Customer;
import com.dealership.pojos.Employee;
import com.dealership.pojos.Offer;
import com.dealership.pojos.Payment;
import com.dealership.pojos.SoldCar;
import com.dealership.pojos.UnsoldCar;
import com.dealership.pojos.User;
import com.dealership.util.DatabaseConnector;

public class CustomerDAO implements DealershipDAO {

	@Override
	public String getPasswordHashForUser(String username) {
		String hash = null;
		String sql = "SELECT password_hash FROM users WHERE user_id = ?";
		
		username = username.toLowerCase();
		
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				hash = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database connection not found!\n"
					+ "Check the src/main/resrouces/dbconnector.properties file for proper username, password, and url.");
		}
		
		return hash;
	}

	@Override
	public User getUserData(String username) {
		User user = null;
		String sql = "SELECT * FROM users WHERE user_id = ?";
		
		username = username.toLowerCase();
		
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getBoolean(4)) {
					PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM employees WHERE user_id = ?");
					ps2.setString(1, username);
					
					ResultSet employeeData = ps2.executeQuery();
					employeeData.next();
					
					user = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(5),
							employeeData.getBoolean(2));
				} else {
					user = new Customer(rs.getString(1), rs.getString(2), rs.getString(3));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database connection not found!\n"
					+ "Check the src/main/resrouces/dbconnector.properties file for proper username, password, and url.");
		}
		
		return user;
	}

	@Override
	public boolean doesUsernameExist(String username) {
		boolean result = false;
		String sql = "SELECT user_id FROM users WHERE user_id = ?";
		
		username = username.toLowerCase();
		
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database connection not found!\n"
					+ "Check the src/main/resrouces/dbconnector.properties file for proper username, password, and url.");
		}
		
		return result;
	}
	
	@Override
	public boolean createUser(User user) {
		boolean result = false;
		boolean isCustomer;
		boolean isEmployee;
		boolean isManager;
		
		if(user instanceof Customer) {
			isCustomer = true;
			isEmployee = false;
			isManager = false;
		}
		else if(user instanceof Employee) {
			Employee emp = (Employee)user;
			
			isCustomer = emp.isCustomer();
			isEmployee = true;
			isManager = emp.isManager();
		}
		else
			return result;
		
		try(Connection conn = openConnection()){
			String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,  user.getUsername());
			ps.setString(2, user.getPasswordHash());
			ps.setString(3, user.getColloquialName());
			ps.setBoolean(4, isEmployee);
			ps.setBoolean(5, isCustomer);
			
			int updated = ps.executeUpdate();
			
			if(updated > 0) {
				if(isEmployee) {
					PreparedStatement ps2 = conn.prepareStatement("INSERT INTO employees VALUES (?, ?)");
					
					ps2.setString(1, user.getUsername());
					ps2.setBoolean(2, isManager);
					
					ps2.executeUpdate();
				}
				result = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return result;
	}
	

	@Override
	public ArrayList<UnsoldCar> getUnsoldCars() {
		ArrayList<UnsoldCar> list = new ArrayList<>();
		String sql = "SELECT cars.car_id, color, model_year, make, model_type, list_price "
				+ "FROM cars, unsold_cars "
				+ "WHERE cars.car_id = unsold_cars.car_id;";
		
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
				list.add(new UnsoldCar(
						rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getString(4), rs.getString(5), rs.getFloat(6)
					));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void createOffer(Offer offer) {
		try(Connection conn = openConnection()){
			PreparedStatement cs = conn.prepareStatement("CALL insert_or_update_offer(?, ?, ?, ?, ?, ?)");
			
			cs.setString(1, offer.getCustomerId());
			cs.setInt(2, offer.getCarId());
			cs.setFloat(3, offer.getOfferAmount());
			cs.setFloat(4, offer.getDownPayment());
			cs.setInt(5, offer.getLoanTermInMonths());
			cs.setFloat(6, offer.getYearlyInterest());
			
			cs.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Offer> getOffers(UnsoldCar car) {
		ArrayList<Offer> offers = new ArrayList<>();
		String sql = "SELECT * FROM offers WHERE car_id = ?";
		
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, car.getCarId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
				offers.add(new Offer(
						rs.getInt(2), rs.getString(1), rs.getFloat(3),
						rs.getFloat(4), rs.getInt(5), rs.getFloat(6)
					));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return offers;
	}
	
	@Override
	public void addEmployeeToCustomerBase(Employee user) {
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE users"
					+ " SET is_customer = true"
					+ " WHERE user_id = ?");
			
			ps.setString(1, user.getUsername());
			
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getNameForUser(String customerId) {
		String result = "";
		
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement(
					"SELECT colloquial_name FROM users"
					+ " WHERE user_id = ?");
			
			ps.setString(1, customerId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
				result = rs.getString(1);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
//	create or replace procedure accept_offer(carid integer, userid text, startdate date, enddate date, dueamount float,
//			apr float, remaining float, payment float, whenaccepted timestamp, down float)
	@Override
	public boolean acceptOffer(Offer offer) {
		Date startDate = new Date(System.currentTimeMillis());
		
		Date endDate = Date.valueOf( LocalDate.now().plusMonths(offer.getLoanTermInMonths()) );
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		
		float remainder = ((float)Math.round((offer.getOfferAmount() - offer.getDownPayment())*100f)) / 100f;
		
		float paymentDue = Utilities.calculateMonthlyPayment(
				remainder, offer.getDownPayment(), offer.getLoanTermInMonths(), offer.getYearlyInterest());
		
		
		
		
		boolean success = false;
		try(Connection conn = openConnection()){
			PreparedStatement cs = conn.prepareStatement("CALL accept_offer(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			cs.setInt(1, offer.getCarId());
			cs.setString(2, offer.getCustomerId());
			cs.setDate(3, startDate);
			cs.setDate(4, endDate);
			cs.setFloat(5, offer.getOfferAmount());
			cs.setFloat(6, offer.getYearlyInterest());
			cs.setFloat(7, remainder);
			cs.setFloat(8, paymentDue);
			cs.setTimestamp(9, startTime);
			cs.setFloat(10, offer.getDownPayment());
			
			cs.execute();
			
			success = true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}
	
	@Override
	public void rejectOffer(Offer offer) {
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM offers WHERE user_id = ? AND car_id = ?");
			
			ps.setInt(1, offer.getCarId());
			ps.setString(2, offer.getCustomerId());
			
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void removeCarListing(Car car) {
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM cars WHERE car_id = ?");
			
			ps.setInt(1, car.getCarId());
			
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void commitCarChanges(UnsoldCar car) {
		try(Connection conn = openConnection()){
			PreparedStatement cs = conn.prepareStatement("CALL update_unsold_car(?, ?, ?, ?, ?, ?)");
			
			cs.setInt(1, car.getCarId());
			cs.setString(2, car.getColor());
			cs.setInt(3, car.getYear());
			cs.setString(4, car.getMake());
			cs.setString(5, car.getModel());
			cs.setFloat(6, car.getListPrice());
			
			cs.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public int listNewCar(UnsoldCar car) {
		int result = -1;
		
		try(Connection conn = openConnection()){
			PreparedStatement cs = conn.prepareStatement("CALL create_unsold_car(?, ?, ?, ?, ?)");
			
			cs.setString(1, car.getColor());
			cs.setInt(2, car.getYear());
			cs.setString(3, car.getMake());
			cs.setString(4, car.getModel());
			cs.setFloat(5, car.getListPrice());
			
			cs.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(car_id) from cars;");
		
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				result = rs.getInt("max");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public ArrayList<SoldCar> getSoldCars(User user) {
		ArrayList<SoldCar> list = new ArrayList<>();
		
		String sql = "SELECT cars.car_id, user_id, color, model_year, make,"
					+ " model_type, start_date, end_date, total_due, yearly_interest,"
					+ " remaining_balance, monthly_payment"
						+ " FROM cars, sold_cars"
						+ " WHERE cars.car_id = sold_cars.car_id AND"
						+ " sold_cars.user_id = ?";
		
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUsername());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
				list.add(new SoldCar(
						rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5), rs.getString(6),
						rs.getDate(7), rs.getDate(8), rs.getFloat(9),
						rs.getFloat(10), rs.getFloat(11), rs.getFloat(12)
					));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public ArrayList<SoldCar> getSoldCars() {
		ArrayList<SoldCar> list = new ArrayList<>();
		
		String sql = "SELECT cars.car_id, user_id, color, model_year, make,"
					+ " model_type, start_date, end_date, total_due, yearly_interest,"
					+ " remaining_balance, monthly_payment"
						+ " FROM cars, sold_cars"
						+ " WHERE cars.car_id = sold_cars.car_id;";
		
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
				list.add(new SoldCar(
						rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5), rs.getString(6),
						rs.getDate(7), rs.getDate(8), rs.getFloat(9),
						rs.getFloat(10), rs.getFloat(11), rs.getFloat(12)
					));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public ArrayList<Payment> getPayments(SoldCar car) {
		ArrayList<Payment> list = new ArrayList<>();
		
		String sql = "SELECT * FROM payments WHERE car_id = ?";
		
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, car.getCarId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
				list.add(new Payment(
						rs.getInt(1), rs.getString(2), rs.getTimestamp(3),
						rs.getFloat(4), rs.getBoolean(5)
					));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void makePayment(Payment payment) {
		try(Connection conn = openConnection()){
			PreparedStatement cs = conn.prepareStatement("CALL make_payment(?, ?, ?, ?)");
			
			cs.setInt(1, payment.getCarId());
			cs.setString(2, payment.getOwnerId());
			cs.setTimestamp(3, payment.getPayDate());
			cs.setFloat(4, payment.getPayAmount());
			
			cs.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Employee> getEmployees() {
		ArrayList<Employee> list = new ArrayList<>();
		
		String sql = "SELECT users.user_id, password_hash, colloquial_name, is_customer, is_manager"
				+ " FROM users JOIN employees"
				+ " ON users.user_id = employees.user_id;";
		
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
				list.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getBoolean(4), rs.getBoolean(5)
					));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public void registerUserAsEmployee(String username) {
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE users"
					+ " SET is_employee = true"
					+ " WHERE user_id = ?;");
			
			ps.setString(1, username);
			
			ps.executeUpdate();
			
			
			
			PreparedStatement ps2 = conn.prepareStatement("INSERT INTO employees VALUES (?, FALSE);");
			
			ps2.setString(1, username);
			
			try {
				ps2.executeUpdate();
			} catch(SQLException e) {
				System.out.println("\nThat account was already an employee!\n");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void promoteEmployee(Employee empl) {
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE employees"
					+ " SET is_manager = true"
					+ " WHERE user_id = ?;");
			
			ps.setString(1, empl.getUsername());
			
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void removeEmployee(Employee empl) {
		try(Connection conn = openConnection()){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM employees"
					+ " WHERE user_id = ?;");
			
			ps.setString(1, empl.getUsername());
			
			ps.executeUpdate();
			
			
			
			PreparedStatement ps2 = conn.prepareStatement("UPDATE users"
					+ " SET is_employee = false"
					+ " WHERE user_id = ?;");
			
			ps2.setString(1, empl.getUsername());
			
			ps2.executeUpdate();
			
			
			
			PreparedStatement ps3 = conn.prepareStatement("UPDATE users"
					+ " SET is_customer = true"
					+ " WHERE user_id = ?;");
			
			ps3.setString(1, empl.getUsername());
			
			ps3.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Connection openConnection() throws SQLException {
		return DatabaseConnector.getInstance().getConnection();
	}

	@Override
	public void closeAllConnections() {
		
	}
}