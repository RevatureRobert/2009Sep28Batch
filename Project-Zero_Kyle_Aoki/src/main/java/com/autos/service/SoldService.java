package com.autos.service;

import com.autos.repository.DAO.SoldDAO;
import com.autos.utility.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SoldService {
    private final SoldDAO sd = new SoldDAO();
    public void viewMyCars(String username){
        ResultSet resultSet = sd.selectSoldCarsByUsername(username);
        Utils.printTable(resultSet);
    }
    public void selectSpecificSoldCar(String sold_id){
        ResultSet resultSet = sd.selectSoldCarsBySoldId(sold_id);
        Utils.printTable(resultSet);
    }
    public boolean doesUserOwnCar(String username, String sold_id){
        ResultSet resultSet = sd.selectSoldCarsByUsernameAndSoldId(username, sold_id);
        boolean b = false;
        try {
            b =  resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return b;
    }
}
