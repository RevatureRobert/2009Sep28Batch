package com.autos.controller.viewers;

import com.autos.UI.ScannerSingleton;
import com.autos.utility.Lr;
import com.autos.service.PaymentsService;

import java.util.Scanner;

public class PaymentsViewer {

    private final Scanner scanner = ScannerSingleton.getInstance().getScanner();
    private final PaymentsService pds = new PaymentsService();

    public void view () {
        Lr.inst().log("Viewed All Payments");
        while (true){
            pds.viewAllPayments();
            System.out.println("Enter 'b' to Go Back");
            System.out.println();
            String response = scanner.nextLine();
            if (response.equals("b")) break;
        }
    }

}
