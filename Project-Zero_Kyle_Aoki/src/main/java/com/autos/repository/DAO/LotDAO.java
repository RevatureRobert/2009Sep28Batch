package com.autos.repository.DAO;

import com.autos.models.Vehicle;
import com.autos.repository.ConnectionSingleton;
import com.autos.repository.DAO.interfaces.LotInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LotDAO implements LotInterface {

    @Override
    public ResultSet selectAllCars() {
        ResultSet resultSet = null;
        String sql = "select * from projectzero.lot;";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            resultSet = prep.executeQuery();
        } catch (SQLException e){
            e.getErrorCode();
        }
        return resultSet;
    }

    @Override
    public void insertNewCar(Vehicle v1) {
        String sql = "insert into projectzero.lot (make, model, yr, msrp, color) values (?, ?, ?, ?, ?);";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);

            int yr = Integer.parseInt(v1.getYr());
            double msrp = Double.parseDouble(v1.getMsrp());

            prep.setString(1, v1.getMake());
            prep.setString(2, v1.getModel());
            prep.setInt(3, yr);
            prep.setDouble(4, msrp);
            prep.setString(5, v1.getColor());

            prep.execute();
        } catch (SQLException e){
            e.getErrorCode();
        }
    }

    @Override
    public ResultSet selectCarByLotId(String lot_id) {
        ResultSet resultSet = null;
        String sql = "select * from projectzero.lot where lot_id = ?;";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            int lot_id_int = Integer.parseInt(lot_id);
            prep.setInt(1, lot_id_int);
            resultSet = prep.executeQuery();
        } catch (SQLException e){
            e.getErrorCode();
        }
        return resultSet;
    }

    @Override
    public void deleteCar(String lot_id) {
        String sql = "delete from projectzero.lot where lot_id = ?;";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            int lot_id_int = Integer.parseInt(lot_id);
            prep.setInt(1, lot_id_int);
            prep.execute();
        } catch (SQLException e){
            e.getErrorCode();
        }
    }
}
