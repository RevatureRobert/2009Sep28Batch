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
import com.cardealership.model.Employee;
import com.cardealership.model.UserType;

public class AdminDao implements DaoContract<Admin, Integer> {

	public List<Admin> findAll() {
		List<Admin> admins = new LinkedList<>();
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "select * from dealership_user where user_type ='admin'";
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet rs = s.executeQuery();
			
			while(rs.next()) {
				String sqlA = "select * from dealership_admin where user_id = ?";
				PreparedStatement sA = conn.prepareStatement(sqlA);
				sA.setInt(1, rs.getInt(1));
				ResultSet rsA =  sA.executeQuery();
				rsA.next();
				admins.add(new Admin(rsA.getInt(1), rsA.getInt(2), rs.getInt(1), rs.getString(2), rs.getString(3), UserType.admin,rs.getString(5),rs.getString(6),rs.getString(7)));
				
			}
			rs.close();
			s.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return admins;
	}
	//i is admin_id
	public Admin findById(Integer i) {
		Admin admin;
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "select * from dealership_admin where admin_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, i);
			ResultSet rs = s.executeQuery();
			rs.next();
			
			String sqlU = "select * from dealership_user where user_id = ?";
			PreparedStatement sU = conn.prepareStatement(sqlU);
			sU.setInt(1, rs.getInt(3));
			ResultSet rsU =  sU.executeQuery();
			rsU.next();
			
			admin = new Admin(rs.getInt(1), rs.getInt(2), rs.getInt(3), rsU.getString(2), rsU.getString(3), UserType.admin,rsU.getString(5),rsU.getString(6),rsU.getString(7));
			rs.close();
			s.close();
			rsU.close();
			sU.close();
			return admin;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public Admin update(Admin t) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "update dealership_user set user_username = ?, user_password = ?, user_first_name = ?, user_last_name = ?, user_email = ? where user_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, t.getUserUserName());
			s.setString(2, t.getUserPassword());
			s.setString(3, t.getUserFirstName());
			s.setString(4, t.getUserLastName());
			s.setString(5, t.getUserEmail());
			s.setInt(6, t.getUserId());
			s.executeUpdate();
			String sqla = "update dealership_admin set dealership_id = ? where admin_id = ?";
			PreparedStatement sa = conn.prepareStatement(sqla);
			sa.setInt(1, t.getDealershipId());
			sa.setInt(2, t.getAdminId());
			sa.executeUpdate();
			s.close();
			sa.close();
			return t;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//account must first be created as a customer to be "upgraded" to admin
	public Admin create(Employee t) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "update dealership_user set user_type = 'admin' where user_id = ?";
			String sqla = "insert into dealership_admin (dealership_id, user_id) values (?, ?)";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, t.getUserId());
			s.executeUpdate();
			PreparedStatement sa = conn.prepareStatement(sqla);
			sa.setInt(1, t.getDealershipId());
			sa.setInt(2, t.getUserId());
			sa.executeUpdate();
			
			//delete employee information
			String sqlDelete = "delete from dealership_employee where user_id = ?";
			PreparedStatement sde = conn.prepareStatement(sqlDelete);
			sde.setInt(1, t.getUserId());
			sde.executeUpdate();
			
			//create new admin object
			String sqlGetAId = "Select admin_id from dealership_admin where user_id = ?";
			PreparedStatement sgaid = conn.prepareStatement(sqlGetAId);
			sgaid.setInt(1, t.getUserId());
			ResultSet rsgaid = sgaid.executeQuery();
			rsgaid.next();
			
			
			Admin admin = new Admin(rsgaid.getInt(1), t.getDealershipId(), t.getUserId(), t.getUserUserName(),
					t.getUserPassword(), UserType.admin, t.getUserFirstName(), t.getUserLastName(), t.getUserEmail());
			rsgaid.close();
			sgaid.close();
			s.close();
			sa.close();
			return admin;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//i is the user id
	public int delete(Integer i) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
		String sql = "delete from dealership_admin where user_id = ?";
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
	public Admin getAdmin(String username) {
		Admin admin;
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()){
			String sql = "select * from dealership_user where user_username = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, username);
			ResultSet rs = s.executeQuery();
			rs.next();
			String sqla = "select * from dealership_admin where user_id = ?";
			PreparedStatement sa = conn.prepareStatement(sqla);
			sa.setInt(1, rs.getInt(1));
			ResultSet rsa = sa.executeQuery();
			rsa.next();
			
			admin = new Admin( rsa.getInt(1),  rsa.getInt(2), rs.getInt(1), rs.getString(2), rs.getString(3), UserType.admin, rs.getString(5), rs.getString(6), rs.getString(7));
			return admin;
		}catch(SQLException e) {
			
		}
		return null;
	}
}
