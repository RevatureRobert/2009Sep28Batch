package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.config.FileConnectionUtil;
import com.revature.model.Manager;

public class ManagerDao implements DaoContract<Manager, Integer>{
	private EmployeeDao ed;
	public List<Manager> findAll() {
		List<Manager> managers = new LinkedList<>();
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from managers";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				managers.add(new Manager(ed.findById(rs.getInt(1))));
			}
			rs.close();
			s.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return managers;
	}

	public Manager findById(Integer i) {
		Manager m = null;
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from managers where employee_id = ?"; //this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				m = new Manager(ed.findById(rs.getInt(1)));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	public Manager update(Manager t) {
		//mangers table just holds a foreign key to the employee table, no need to update
		return t;
	}

	public Manager create(Manager t) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into managers (employee_id) values (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getEmployee().getEmployeeID());
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	public int delete(Integer i) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "delete from managers where employee_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return - 1;
		}
		return i;
	}

}
