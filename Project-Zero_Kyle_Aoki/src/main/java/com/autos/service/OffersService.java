package com.autos.service;

import com.autos.repository.DAO.OffersDAO;
import com.autos.utility.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class OffersService {

    private final OffersDAO od = new OffersDAO();

    public void viewMyOffers(String username){
        ResultSet resultSet = od.selectOffersByUsername(username);
        Utils.printTable(resultSet);
    }

    public void viewAllOffers(){
        ResultSet resultSet = od.selectAllOffers();
        Utils.printTable(resultSet);
    }

    public boolean doesOfferExist(String offer_id){
        ResultSet resultSet = od.selectOffersByOfferId(offer_id);
        try {
            return resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public HashMap<String, String> getOfferDetails(String offer_id){
        ResultSet resultSet = od.selectOffersByOfferId(offer_id);
        HashMap<String, String> offerDetails = new HashMap<>();
        try {
            while (resultSet.next()){
                offerDetails.put("offer_id", Integer.toString(resultSet.getInt("offer_id")));
                offerDetails.put("make", resultSet.getString("make"));
                offerDetails.put("model", resultSet.getString("model"));
                offerDetails.put("yr", Integer.toString(resultSet.getInt("yr")));
                offerDetails.put("msrp", Double.toString(resultSet.getDouble("msrp")));
                offerDetails.put("color", resultSet.getString("color"));
                offerDetails.put("username", resultSet.getString("username"));
                offerDetails.put("offer", Double.toString(resultSet.getDouble("offer")));
            }
        } catch (SQLException e) { e.getErrorCode(); }
        Utils.printTable(offerDetails);
        return offerDetails;
    }

    public void acceptOffer(String offer_id) {
        od.acceptOffer(offer_id);
    }

    public void rejectOffer(String offer_id) {
        od.rejectOffer(offer_id);
    }

    public void insertOffer(String lot_id, String username, String offer){
        od.insertOffer(lot_id, username, offer);
    }
}
