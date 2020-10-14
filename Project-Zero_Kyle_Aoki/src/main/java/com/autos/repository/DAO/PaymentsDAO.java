package com.autos.repository.DAO;

import com.autos.repository.DAO.interfaces.PaymentsInterface;
import com.autos.repository.ConnectionSingleton;

import java.sql.*;

public class PaymentsDAO implements PaymentsInterface {

    @Override
    public ResultSet selectAllPayments() {
        ResultSet resultSet = null;
        String sql = "select payment_id, sold_id, username, payment_amount, remaining_balance, datetime from projectzero.payments;";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            resultSet = prep.executeQuery();
        } catch (SQLException e){
            System.out.println("Error Getting All Payments");
        }
        return resultSet;
    }

    @Override
    public ResultSet makePayment(String sold_id, String username, double payment_amount){
        String sql = "select * from projectzero.make_payment( "+sold_id+", '"+username+"', "+payment_amount+");";
        ResultSet resultSet = null;
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            Statement prep = conn.createStatement();
            resultSet = prep.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public ResultSet selectPaymentsByUsername(String username) {
        String sql = "select payment_id, payments.username, make, model, yr, payment_amount, datetime " +
                "from projectzero.payments " +
                "join projectzero.sold on payments.sold_id = sold.sold_id " +
                "where payments.username = ?";
        ResultSet resultSet = null;
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, username);
            resultSet = prep.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

}























