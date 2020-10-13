package com.carsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.carsales.model.Auto;
import com.carsales.model.Payment;
import com.carsales.util.ConnectionUtil;

public class PaymentDao {
	
	public int AddPayments(Payment pay)
	{
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement add = conn.prepareStatement("insert into carlot_schema.payments_tab (payment_num, car_id, user_id, username_t, o_amount) "
					+ "values (?, ?, ?, ?, ?);");
			
			add.setInt(1, pay.getPaymentnum());
			add.setInt(2, pay.getCar_id());
			add.setInt(3, pay.getUserid());
			add.setString(4, pay.getUsername());
			add.setInt(5, pay.getAmount());
			if(!add.execute())
				return 1;
			
			add.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public List<Payment> getPaymentbvCar(int id)
	{
		List<Payment> payments = new LinkedList<Payment>();
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement remo = conn.prepareStatement("select * from carlot_schema.payments_tab where car_id= ?");
			remo.setInt(1,id);
			ResultSet rs = remo.executeQuery();
			while(rs.next())
			{
				payments.add(new Payment(rs.getInt("payment_id"), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
			}
			
			remo.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return payments;
		
	}
	
	public List<Payment> getAllPayment()
	{
		List<Payment> payments = new LinkedList<Payment>();
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement remo = conn.prepareStatement("select * from carlot_schema.payments_tab");
			ResultSet rs = remo.executeQuery();
			while(rs.next())
			{
				payments.add(new Payment(rs.getInt("payment_id"), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
			}
			
			remo.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return payments;
		
	}
	
	public int removePayment(int id)
	{
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement remo = conn.prepareStatement("delete from carlot_schema.payments_tab where payment_id = ?");
			remo.setInt(1,id);
			if(!remo.execute())
			{
				return 1;
			}
			
			remo.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
		
	}

}
