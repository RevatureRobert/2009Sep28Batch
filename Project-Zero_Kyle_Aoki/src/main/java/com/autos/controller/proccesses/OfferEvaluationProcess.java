package com.autos.controller.proccesses;

import com.autos.UI.ScannerSingleton;
import com.autos.utility.Lr;
import com.autos.service.OffersService;

import java.util.HashMap;
import java.util.Scanner;

public class OfferEvaluationProcess {
    private boolean offerEvaluationProcessStatus = true;
    private final Scanner scanner = ScannerSingleton.getInstance().getScanner();
    private final OffersService ods = new OffersService();

    public void evaluate(){
        Lr.inst().log("Evaluated Offers");
        while (offerEvaluationProcessStatus) {
            System.out.println();
            ods.viewAllOffers();
            System.out.println();
            System.out.println("Select 'OFFER_ID' To Continue or Enter 'b' To Go Back");
            String response = scanner.nextLine();
            if (this.isValidOfferId(response)){
                this.acceptOrRejectOffer(response);
            } else if (response.equals("b")){
                break;
            }
        }
    }

    private void acceptOrRejectOffer(String offer_id){
        acceptOrRejectOffer:
        while (offerEvaluationProcessStatus) {
            System.out.println();
            HashMap<String, String> offerInfo = ods.getOfferDetails(offer_id);
            System.out.println();
            System.out.println("Evaluate Offer (Enter 'b' To Go Back)");
            calculateDifference(offerInfo.get("offer"), offerInfo.get("msrp"));
            System.out.println("(1) Accept Offer");
            System.out.println("(2) Reject Offer");
            String response = scanner.nextLine();
            switch (response) {
                case "1":
                    Lr.inst().log("Accepted Offer_Id: "+offerInfo.get("offer_id"));
                    System.out.println("Offer Accepted");
                    this.acceptOffer(offerInfo.get("offer_id"));
                    this.setOfferEvaluationProcessStatus(false);
                    break;
                case "2":
                    Lr.inst().log("Rejected Offer_Id: "+offerInfo.get("offer_id"));
                    System.out.println("Offer Rejected");
                    this.rejectOffer(offerInfo.get("offer_id"));
                    this.setOfferEvaluationProcessStatus(false);
                    break;
                case "b":
                    break acceptOrRejectOffer;
            }
        }
    }

    // Helpers

    private void acceptOffer(String offer_id) {
        ods.acceptOffer(offer_id);
    }

    private void rejectOffer(String offer_id) {
        ods.rejectOffer(offer_id);
    }

    private boolean isValidOfferId(String offer_id){
        try {
            Integer.parseInt(offer_id);
            if (!ods.doesOfferExist(offer_id)){
                System.out.println("Offer Does Not Exist");
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void calculateDifference(String offer, String msrp){
        double x1 = Double.parseDouble(offer);
        double x2 = Double.parseDouble(msrp);
        double diff = x1 - x2;
        if (diff >= 0) {
            System.out.println("Offer is $" + diff + " higher than MSRP.");
        } else {
            System.out.println("Offer is $" + Math.abs(diff) + " lower than MSRP");
        }
    }

    public void setOfferEvaluationProcessStatus(boolean offerEvaluationProcessStatus) {
        this.offerEvaluationProcessStatus = offerEvaluationProcessStatus;
    }
}
