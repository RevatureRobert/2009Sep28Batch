package com.autos.repository.DAO.interfaces;

import java.sql.ResultSet;

public interface OffersInterface {
    ResultSet selectOffersByUsername(String username);
    ResultSet selectAllOffers();
    ResultSet selectOffersByOfferId(String offer_id);
    void acceptOffer(String offer_id);
    void rejectOffer(String offer_id);
    void insertOffer(String lot_id, String username, String offer);
}
