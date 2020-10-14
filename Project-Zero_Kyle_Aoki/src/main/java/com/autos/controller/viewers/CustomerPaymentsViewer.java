package com.autos.controller.viewers;

import com.autos.UI.ScannerSingleton;
import com.autos.service.PaymentsService;
import com.autos.service.UsersService;

import java.util.Scanner;

public class CustomerPaymentsViewer {
    
    private final Scanner scanner = ScannerSingleton.getInstance().getScanner();
    private final UsersService uds = new UsersService();
    private final PaymentsService pds = new PaymentsService();
    private boolean viewing = true;
    
    public void view() {
        while (viewing) {
            System.out.println();
            uds.viewAllCustomers();
            System.out.println();
            System.out.println("Enter Username of Customer To View Payments, or Enter 'b' To Go Back");
            String response = scanner.nextLine();
            if (response.equals("b")) { break; }
            else if (isValidUsername(response)) {
                viewPayments(response);
            }
        }
    }
    
    public void viewPayments(String username) {
        while (viewing) {
            System.out.println();
            pds.viewPaymentsOfCustomer(username);
            System.out.println();
            System.out.println("Enter 'q' To Quit Payments Viewer, or Enter 'b' To Go Back");
            String response = scanner.nextLine();
            if (response.equals("b")) { break; }
            else if (response.equals("q")) { stopViewing(); }
        }
    }
    
    public boolean isValidUsername(String username){
        return uds.doesUserExist(username);
    }
    
    private void stopViewing() {
        this.viewing = false;
    }
}
