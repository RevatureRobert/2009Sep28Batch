package com.autos.repository.DAO.interfaces;

import com.autos.models.Vehicle;

import java.sql.ResultSet;

public interface LotInterface {
    ResultSet selectAllCars();
    void insertNewCar(Vehicle v1);
    ResultSet selectCarByLotId(String lot_id);
    void deleteCar(String lot_id);
}
