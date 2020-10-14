package com.autos.controller.proccesses;

import com.autos.UI.ScannerSingleton;
import com.autos.utility.Lr;
import com.autos.service.OffersService;
import com.autos.service.LotService;
import com.autos.models.Vehicle;

import java.util.Scanner;

public class MakeOfferProcess {

    private final Scanner scanner = ScannerSingleton.getInstance().getScanner();
    private final LotService lds = new LotService();
    private final OffersService ods = new OffersService();
    private boolean offerProcessStatus = true;
    private String username;


    public void offerProcess(String username){
        Lr.inst().log("Started Offer Process");
        setUsername(username);
        chooseCar();
    }
    private void chooseCar(){
        while (offerProcessStatus) {
            lds.viewLot();
            System.out.println();
            System.out.println("Choose LOT_ID of Car To Make An Offer (Or Enter 'b' To Go Back)");
            String response = scanner.nextLine();
            if (isValidLotId(response)) {
                makeOffer(response);
            } else if (response.equals("b")) {
                break;
            }
        }
    }
    private void makeOffer(String lot_id){
        do {
            System.out.println("Make Your Offer On Vehicle (Or Enter 'b' To Go Back): ");
            Vehicle v1 = lds.getVehicle(lot_id);
            printVehicleInfo(v1);
            System.out.println("Offer: ");
            String offer = scanner.nextLine();
            if (isValidPrice(offer, v1.getMsrp())){
                confirmOffer(offer, lot_id, v1);
            } else if (offer.equals("b")){
                break;
            }
        } while (offerProcessStatus);
    }
    private void confirmOffer(String offer, String lot_id, Vehicle v1){
        do {
            System.out.println("You have offered $" + offer + " on a " + v1.getYr() + " " + v1.getMake() + " " + v1.getModel() + ".");
            System.out.println("Enter 'confirm' to confirm your offer, or enter 'b' to go back.");
            String response = scanner.nextLine();
            if (response.equals("confirm")){
                Lr.inst().log("Made Offer On Lot_Id: " + lot_id + " of $" + offer);
                enterOfferIntoDatabase(lot_id, username, offer);
                break;
            } else if (response.equals("b")){
                break;
            }
        } while (offerProcessStatus);
    }
    private void enterOfferIntoDatabase(String lot_id, String username, String offer){
        ods.insertOffer(lot_id, username, offer);
        setOfferProcessStatus(false);
    }

    // Helpers
    private boolean isValidPrice(String price, String msrp){
        try {
            double p1 = Double.parseDouble(price);
            double p2 = Double.parseDouble(msrp);
            if (p1 > (3 * p2)){
                System.out.println("Serious Offers Only");
                return false;
            } else if (p1 < p2 * 0.3) {
                System.out.println("No Lowball Offers");
                return false;
            }
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
    private boolean isValidLotId(String lot_id){
        try {
            Integer.parseInt(lot_id);
             if (!lds.doesCarExist(lot_id)) {
                 System.out.println("Car Does Not Exist");
                 return false;
             }
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
    private void printVehicleInfo(Vehicle v1){
        System.out.println("---> Make: " + v1.getMake() + ", Model: " + v1.getModel() + ", Year: " + v1.getYr() + ", MSRP: " + v1.getMsrp()
        + ", Color: " + v1.getColor());
    }
    public void setOfferProcessStatus(boolean offerProcessStatus) {
        this.offerProcessStatus = offerProcessStatus;
    }
    private void setUsername(String username) {
        this.username = username;
    }
}
