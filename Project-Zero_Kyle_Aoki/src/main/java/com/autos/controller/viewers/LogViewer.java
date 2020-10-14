package com.autos.controller.viewers;

import com.autos.UI.ScannerSingleton;
import com.autos.utility.Lr;

import java.util.Scanner;

public class LogViewer {

    private final Scanner scanner = ScannerSingleton.getInstance().getScanner();

    public void viewLogs(){

        Lr.inst().log("Viewed Logs");

        while (true) {
            Lr.printAllLogs();
            System.out.println();
            System.out.println("Enter 'b' To Go Back");
            String response = scanner.nextLine();
            if (response.equals("b")) break;
        }
    }

}
