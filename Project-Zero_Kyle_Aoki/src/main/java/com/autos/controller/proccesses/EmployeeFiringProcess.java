package com.autos.controller.proccesses;

import com.autos.UI.ScannerSingleton;
import com.autos.utility.Lr;
import com.autos.service.UsersService;
import com.autos.models.User;

import java.util.Scanner;

public class EmployeeFiringProcess {

    private final Scanner scanner = ScannerSingleton.getInstance().getScanner();
    private final UsersService uds = new UsersService();
    private boolean fireEmployeeProcess = true;

    public void fire(){
        Lr.inst().log("Started Firing Process");
        while (fireEmployeeProcess) {
            System.out.println("Select Username of Employee To Fire: ");
            uds.viewAllEmployees();
            System.out.println("Enter 'b' To Go Back");
            String response = scanner.nextLine();
            if (response.equals("b")) { break; }
            else if (uds.doesUserExist(response)){
                confirmFire(response);
            }
        }
    }
    public void confirmFire(String username){
        confirmFire:
        while (fireEmployeeProcess) {
            System.out.println("You are firing Employee: ");
            User u1 = uds.getUser(username);
            System.out.println("Username: " + u1.getUsername());
            System.out.println("Enter 'confirm' to Fire Employee");
            System.out.println("Enter 'cancel' to Cancel");
            System.out.println("Enter 'b' To Go Back");
            String response = scanner.nextLine();
            switch (response) {
                case "b":
                    break confirmFire;
                case "confirm":
                    Lr.inst().log("Fired " + username);
                    uds.deleteUser(username);
                    System.out.println("Employee " + username + " has been fired.");
                    setFireEmployeeProcess(false);
                    break;
                case "cancel":
                    setFireEmployeeProcess(false);
                    break;
            }
        }
    }

    public void setFireEmployeeProcess(boolean fireEmployeeProcess) {
        this.fireEmployeeProcess = fireEmployeeProcess;
    }
}
