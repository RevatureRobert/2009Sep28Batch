package com.autos.controller.viewers;

import com.autos.UI.ScannerSingleton;
import com.autos.utility.Lr;
import com.autos.service.UsersService;

import java.util.Scanner;

public class EmployeeViewer {
    
    private final UsersService uds = new UsersService();
    private final Scanner scanner = ScannerSingleton.getInstance().getScanner();
    
    public void view(){
        Lr.inst().log("Viewed All Employees");
        while (true){
            System.out.println("List Of Employees: ");
            System.out.println();
            uds.viewAllEmployees();
            System.out.println();
            System.out.println("Enter 'b' To Go Back");
            String response = scanner.nextLine();
            if (response.equals("b")) break;
        }
    }
    
}
