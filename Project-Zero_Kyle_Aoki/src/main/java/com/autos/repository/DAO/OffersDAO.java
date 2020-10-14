package com.autos.repository.DAO;

import com.autos.repository.DAO.interfaces.OffersInterface;
import com.autos.repository.ConnectionSingleton;

import java.sql.*;

public class OffersDAO implements OffersInterface {

    @Override
    public ResultSet selectOffersByUsername(String username) {
        ResultSet resultSet = null;
        String sql = "select offer_id, make, model, yr, msrp, color, username, offer\n" +
                "from projectzero.offers \n" +
                "join projectzero.lot on offers.lot_id = lot.lot_id\n" +
                "where username = ?;";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, username);
            resultSet = prep.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error Selecting Offers By Username");
        }
        return resultSet;
    }

    @Override
    public ResultSet selectAllOffers() {
        ResultSet resultSet = null;
        String sql = "select offer_id, make, model, yr, msrp, color, username, offer\n" +
                "from projectzero.offers \n" +
                "join projectzero.lot on offers.lot_id = lot.lot_id;";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            resultSet = prep.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error Selecting Offers By Username");
        }
        return resultSet;
    }

    @Override
    public ResultSet selectOffersByOfferId(String offer_id) {
        ResultSet resultSet = null;
        String sql = "select * from projectzero.offer_details_by_offer_id(?);";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            int offer_id_int = Integer.parseInt(offer_id);
            prep.setInt(1, offer_id_int);
            resultSet = prep.executeQuery();
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return resultSet;
    }

    @Override
    public void acceptOffer(String offer_id) {
        String sql = "select projectzero.accept_offer(?);";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            int offer_id_int = Integer.parseInt(offer_id);
            prep.setInt(1, offer_id_int);
            prep.execute();
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }

    @Override
    public void rejectOffer(String offer_id) {
        String sql = "delete from projectzero.offers where offer_id = ?;";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            int offer_id_int = Integer.parseInt(offer_id);
            prep.setInt(1, offer_id_int);
            prep.execute();
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }

    @Override
    public void insertOffer(String lot_id, String username, String offer) {
        String sql = "insert into projectzero.offers (lot_id, username, offer) values (?, ?, ?);";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);

            int lot_id_int = Integer.parseInt(lot_id);
            double offer_double = Double.parseDouble(offer);

            prep.setInt(1, lot_id_int);
            prep.setString(2, username);
            prep.setDouble(3, offer_double);

            prep.execute();
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }

}
