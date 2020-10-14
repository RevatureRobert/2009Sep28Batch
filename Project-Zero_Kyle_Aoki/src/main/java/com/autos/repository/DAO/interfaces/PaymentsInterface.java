package com.autos.repository.DAO.interfaces;

import java.sql.ResultSet;

public interface PaymentsInterface {

    ResultSet selectAllPayments();
    ResultSet makePayment(String sold_id, String username, double payment_amount);
    ResultSet selectPaymentsByUsername(String username);
    
}
