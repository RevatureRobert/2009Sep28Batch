package com.autos.controller.viewers;

import com.autos.UI.ScannerSingleton;
import com.autos.utility.Lr;
import com.autos.service.OffersService;

import java.util.Scanner;

public class MyOffersViewer {

    private final Scanner scanner = ScannerSingleton.getInstance().getScanner();
    private final OffersService ods = new OffersService();

    public void view (String username) {
        Lr.inst().log("Viewed My Offers");
        while (true){
            ods.viewMyOffers(username);
            System.out.println("Enter 'b' to Go Back");
            System.out.println();
            String response = scanner.nextLine();
            if (response.equals("b")) break;
        }
    }

}
