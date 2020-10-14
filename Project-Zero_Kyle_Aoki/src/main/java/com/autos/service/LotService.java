package com.autos.service;

import com.autos.repository.DAO.LotDAO;
import com.autos.models.Vehicle;
import com.autos.utility.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LotService {
    private final LotDAO ld = new LotDAO();
    public void viewLot() {
        ResultSet resultSet = ld.selectAllCars();
        Utils.printTable(resultSet);
    }
    public void addNewCarToLot(Vehicle v1){
        ld.insertNewCar(v1);
    }

    public Vehicle getVehicle(String lot_id){
        ResultSet resultSet = ld.selectCarByLotId(lot_id);
        Vehicle v1 = new Vehicle();
        try {
            while (resultSet.next()) {
                v1.setMake(resultSet.getString("make"));
                v1.setModel(resultSet.getString("model"));
                v1.setYr(Integer.toString(resultSet.getInt("yr")));
                v1.setMsrp(Double.toString(resultSet.getDouble("msrp")));
                v1.setColor(resultSet.getString("color"));
            }
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return v1;
    }

    public void deleteCar(String lot_id){  ld.deleteCar(lot_id); }

    public boolean doesCarExist(String lot_id){
        ResultSet resultSet = ld.selectCarByLotId(lot_id);
        boolean b = false;
        try {
            b = resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return b;
    }
}
