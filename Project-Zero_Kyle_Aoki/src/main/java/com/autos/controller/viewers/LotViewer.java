package com.autos.controller.viewers;

import com.autos.UI.ScannerSingleton;
import com.autos.utility.Lr;
import com.autos.service.LotService;

import java.util.Scanner;

public class LotViewer {

    private final Scanner scanner = ScannerSingleton.getInstance().getScanner();
    private final LotService lds = new LotService();

    public void view () {
        Lr.inst().log("Viewed Lot");
        while (true){
            lds.viewLot();
            System.out.println("Enter 'b' to Go Back");
            System.out.println();
            String response = scanner.nextLine();
            if (response.equals("b")) break;
        }
    }
}
