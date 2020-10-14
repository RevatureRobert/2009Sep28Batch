package com.autos.controller.viewers;

import com.autos.UI.ScannerSingleton;
import com.autos.utility.Lr;
import com.autos.service.SoldService;

import java.util.Scanner;

public class MyCarsViewer {

    private final Scanner scanner = ScannerSingleton.getInstance().getScanner();
    private final SoldService sds = new SoldService();

    public void view (String username) {
        Lr.inst().log("Viewed My Cars");
        while (true){
            sds.viewMyCars(username);
            System.out.println("Enter 'b' to Go Back");
            System.out.println();
            String response = scanner.nextLine();
            if (response.equals("b")) break;
        }
    }

}
