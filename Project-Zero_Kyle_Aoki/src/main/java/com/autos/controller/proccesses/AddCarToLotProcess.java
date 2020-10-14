package com.autos.controller.proccesses;

import com.autos.UI.ScannerSingleton;
import com.autos.utility.Lr;
import com.autos.controller.validators.NewCarValidator;
import com.autos.service.LotService;
import com.autos.models.Vehicle;

import java.util.Scanner;

public class AddCarToLotProcess {
    
    private final Scanner scanner = ScannerSingleton.getInstance().getScanner();
    private final LotService lotService = new LotService();
    private final NewCarValidator carInfoValidator = new NewCarValidator();

    public void startInformationCollection() {
        Lr.inst().log("Started New Car Addition Process");
        boolean cont = false;

        String make;
        String model = null;
        String yr = null;
        String msrp = null;
        String color = null;

        while (true) {

            System.out.println("Enter 'b' Anytime To Go Back");

            System.out.println("Enter Make: ");
            make = scanner.nextLine();
            if (make.equals("b")) break;

            System.out.println("Enter Model: ");
            model = scanner.nextLine();
            if (model.equals("b")) break;

            System.out.println("Enter Model Year: ");
            yr = scanner.nextLine();
            if (yr.equals("b")) break;

            System.out.println("Enter MSRP: ");
            msrp = scanner.nextLine();
            if (msrp.equals("b")) break;

            System.out.println("Enter Color: ");
            color = scanner.nextLine();
            if (color.equals("b")) break;

            System.out.println("Confirm New Car Input: ");
            System.out.println("Make: " + make);
            System.out.println("model: " + model);
            System.out.println("yeare: " + yr);
            System.out.println("msrp: " + msrp);
            System.out.println("color: " + color);
            System.out.println();
            System.out.println("(1) Continue");
            System.out.println("(2) ReEnter Information");
            System.out.println("(any) Go Back");
            String response = scanner.nextLine();
            if (response.equals("1")) {
                cont = true;
                break;
            } else if (!response.equals("2")) { break; }
        }

        if (cont){
            Vehicle v1 = new Vehicle(make, model, yr, msrp, color);
            if (carInfoValidator.validate(v1)){
                Lr.inst().log("Entered A New Car: " + v1.getYr() + " " + v1.getMake() + " " + v1.getModel());
                lotService.addNewCarToLot(v1);
            } else {
                System.out.println("Invalid Input, Try Again");
            }
        }

    }

}
