package com.autos.service;

import com.autos.repository.DAO.PaymentsDAO;
import com.autos.repository.DAO.SoldDAO;
import com.autos.utility.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentsService {

    private final PaymentsDAO pd = new PaymentsDAO();
    private final SoldDAO sd = new SoldDAO();

    public void viewAllPayments() {
        ResultSet resultSet = pd.selectAllPayments();
        Utils.printTable(resultSet);
    }

    public void makePayment(String sold_id, String username, double payment_amount) {
        ResultSet resultSet = pd.makePayment(sold_id, username, payment_amount);
        double overpay = 0;
        try {
            while (resultSet.next()) {
                overpay = resultSet.getDouble(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (overpay < 0) {
            double refund = -1 * overpay;
            System.out.println("You have completed your payments on this vehicle.");
            System.out.println("You have been given a refund of $" + refund);
        } else if (overpay > 0) {
            System.out.println("You have a remaining balance of $" + overpay);
            double monthlyPayment = 350;
            ResultSet resultSet2 = sd.selectSoldCarsBySoldId(sold_id);
            try {
                while (resultSet2.next()) {
                    monthlyPayment = resultSet2.getDouble("soldfor");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            monthlyPayment = monthlyPayment / 36;
            monthlyPayment = Math.min(monthlyPayment, overpay);
            System.out.println("Your next monthly payment is $" + monthlyPayment);
        }
    }
    
    public void viewPaymentsOfCustomer(String username) {
        ResultSet resultSet = pd.selectPaymentsByUsername(username);
        Utils.printTable(resultSet);
    }

}
