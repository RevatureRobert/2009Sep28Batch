package com.cardealership.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.cardealership.config.EnvironmentConnectionUtil;
import com.cardealership.config.PlainTextConnectionUtil;
import com.cardealership.model.Admin;
import com.cardealership.model.Customer;
import com.cardealership.model.Employee;
import com.cardealership.model.UserType;

public class EmployeeDao implements DaoContract<Employee, Integer> {

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = new LinkedList<>();
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "select * from dealership_user where user_type ='employee'";
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet rs = s.executeQuery();
			
			while(rs.next()) {
				String sqle = "select * from dealership_employee where user_id = ?";
				PreparedStatement se = conn.prepareStatement(sqle);
				se.setInt(1, rs.getInt(1));
				ResultSet rse =  se.executeQuery();
				rse.next();
				employees.add(new Employee(rse.getInt(1), rse.getInt(2), rs.getInt(1), rs.getString(2), rs.getString(3), UserType.admin,rs.getString(5),rs.getString(6),rs.getString(7)));
				
			}
			rs.close();
			s.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee findById(Integer i) {
		Employee employee;
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "select * from dealership_employee where employee_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, i);
			ResultSet rs = s.executeQuery();
			rs.next();
			
			String sqlU = "select * from dealership_user where user_id = ?";
			PreparedStatement sU = conn.prepareStatement(sqlU);
			sU.setInt(1, rs.getInt(3));
			ResultSet rsU =  sU.executeQuery();
			rsU.next();
			
			employee = new Employee(rs.getInt(1), rs.getInt(2), rs.getInt(3), rsU.getString(2), rsU.getString(3), UserType.employee,rsU.getString(5),rsU.getString(6),rsU.getString(7));
			rs.close();
			s.close();
			rsU.close();
			sU.close();
			return employee;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	@Override
	public Employee update(Employee t) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "update dealership_user set user_username = ?, user_password = ?, user_first_name = ?,"+ 
					" user_last_name = ?, user_email = ? where user_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, t.getUserUserName());
			s.setString(2, t.getUserPassword());
			s.setString(3, t.getUserFirstName());
			s.setString(4, t.getUserLastName());
			s.setString(5, t.getUserEmail());
			s.setInt(6, t.getUserId());
			s.executeUpdate();
			String sqla = "update dealership_employee set dealership_id = ? where employee_id = ?";
			PreparedStatement sa = conn.prepareStatement(sqla);
			sa.setInt(1, t.getDealershipId());
			sa.setInt(2, t.getEmployeeId());
			sa.executeUpdate();
			s.close();
			sa.close();
			return t;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//account must first be created as a customer to be "upgraded" to employee

	public Employee create(Customer t, int dealership) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "update dealership_user set user_type = 'employee' where user_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, t.getUserId());
			s.executeUpdate();
			
			String sqla = "insert into dealership_employee(dealership_id, user_id) values (?, ?)";
			PreparedStatement sa = conn.prepareStatement(sqla);
			sa.setInt(1, dealership);
			sa.setInt(2, t.getUserId());
			sa.executeUpdate();
			
			//delete customer table row
			String sqlDelete = "delete from customer where user_id = ?";
			PreparedStatement sd = conn.prepareStatement(sqlDelete);
			sd.setInt(1, t.getUserId());
			sd.executeUpdate();
			
			//create employee object
			String sqlGetId = "select employee_id from dealership_employee where user_id = ?";
			PreparedStatement sgeid = conn.prepareStatement(sqlGetId);
			sgeid.setInt(1, t.getUserId());
			ResultSet rsgeid = sgeid.executeQuery();
			rsgeid.next();
			
			Employee employee = new Employee(rsgeid.getInt(1), dealership, t.getUserId(), t.getUserUserName(), t.getUserPassword(), UserType.employee, t.getUserFirstName(), t.getUserLastName(), t.getUserEmail());
			
			rsgeid.close();
			sgeid.close();
			sd.close();
			s.close();
			sa.close();
			return employee;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	//user id
	public int delete(Integer i) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "delete from dealership_employee where user_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, i);
			s.executeUpdate();
			String sqlu = "delete from dealership_user where user_id = ?"; 
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
	
	public boolean createCar(Employee t, String name, int asking_price, String view) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "insert into unsold_car (unsold_car_name, unsold_car_asking_price, dealership_id) values (?, ?, ?)";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, name);
			s.setInt(2, asking_price);
			s.setInt(3, t.getDealershipId());
			s.executeUpdate();
			s.close();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/*
	 * @param i = unsold_car_id
	 * */
	public boolean deleteCar(Integer i) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "delete from unsold_car where unsold_car_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, i);
			s.executeUpdate();
			s.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public Employee getEmployee(String username) {
		Employee employee;
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "select * from dealership_user where user_username = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, username);
			ResultSet rs = s.executeQuery();
			rs.next();
			String sqla = "select * from dealership_employee where user_id = ?";
			PreparedStatement sa = conn.prepareStatement(sqla);
			sa.setInt(1, rs.getInt(1));
			ResultSet rsa = sa.executeQuery();
			rsa.next();
			
			employee = new Employee( rsa.getInt(1),  rsa.getInt(2), rs.getInt(1), rs.getString(2), rs.getString(3), UserType.employee, rs.getString(5), rs.getString(6), rs.getString(7));
			return employee;
		}catch(SQLException e) {
			
		}
		return null;
	}

}
