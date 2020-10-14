package com.autos.controller.proccesses;

import com.autos.UI.ScannerSingleton;
import com.autos.utility.Lr;
import com.autos.service.PaymentsService;
import com.autos.service.SoldService;

import java.util.Scanner;

public class PaymentProcess {

    private boolean paymentProcessStatus = true;
    private final Scanner scanner = ScannerSingleton.getInstance().getScanner();
    private final PaymentsService pds = new PaymentsService();
    private final SoldService sds = new SoldService();

    public void pay(String username){
        Lr.inst().log("Initiated A Payment Process");
        if (!paymentProcessStatus) this.setPaymentProcessStatus(true);
        while (paymentProcessStatus) {
            System.out.println();
            sds.viewMyCars(username);
            System.out.println();
            System.out.println("Select 'Sold Id' Of Car To make Payment On");
            System.out.println("Enter 'b' To Go Back");
            String response = scanner.nextLine();
            if (response.equals("b")) { break; }
            else if (this.isValidSoldId(username, response)) { this.paymentAmountSelection(username, response); }
        }
    }

    private void paymentAmountSelection(String username, String sold_id){
        while (paymentProcessStatus) {
            System.out.println("You are making a payment on: ");
            sds.selectSpecificSoldCar(sold_id);
            System.out.println();
            System.out.println("Enter Amount To Pay: ");
            String response = scanner.nextLine();
            if (response.equals("b")) { break; }
            else if (this.isValidAmount(response)){
                double payment_amount = Double.parseDouble(response);
                this.confirmPayment(username, sold_id, payment_amount);
            }
        }
    }

    private void confirmPayment(String username, String sold_id, double payment_amount){
        confirmPayment:
        while (paymentProcessStatus) {
            System.out.println("Confirm: ");
            sds.selectSpecificSoldCar(sold_id);
            System.out.println("Payment: " + payment_amount);
            System.out.println("Enter 'confirm' to confirm");
            System.out.println("Enter 'cancel' to cancel");
            System.out.println("Enter 'b' to go back");
            String res = scanner.nextLine();
            switch (res) {
                case "b":
                    break confirmPayment;
                case "confirm":
                    Lr.inst().log("Confirmed Payment of $" + payment_amount);
                    pds.makePayment(sold_id, username, payment_amount);
                    this.setPaymentProcessStatus(false);
                    break;
                case "cancel":
                    this.setPaymentProcessStatus(false);
                    break confirmPayment;
            }
        }
    }

    // Helpers

    private boolean isValidAmount(String response) {
        try {
            double amount = Double.parseDouble(response);
            if (amount < 0) {
                System.out.println("No Loans");
                return false;
            }
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private boolean isValidSoldId(String username, String sold_id){
        try {
            Integer.parseInt(sold_id);
            if (!sds.doesUserOwnCar(username, sold_id)) {
                System.out.println("Invalid Sold_Id");
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public void setPaymentProcessStatus(boolean paymentProcessStatus) { this.paymentProcessStatus = paymentProcessStatus; }
}
