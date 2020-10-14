package com.autos.controller.proccesses;

import com.autos.UI.ScannerSingleton;
import com.autos.utility.Lr;
import com.autos.models.Vehicle;
import com.autos.service.LotService;

import java.util.Scanner;

public class CarDeletionProcess {

    private boolean carDeletionProcess = true;
    private final Scanner scanner = ScannerSingleton.getInstance().getScanner();
    private final LotService lds = new LotService();

    public void deleteCar(){
        Lr.inst().log("Started Car Deletion Process");
        while (carDeletionProcess){
            lds.viewLot();
            System.out.println("Select LOT_ID of Car to Delete or Enter 'b' To Go Back");
            String lot_id = scanner.nextLine();
            if (lot_id.equals("b")) break;
            if (this.isValidLotId(lot_id)){
                this.confirmDeletion(lot_id);
            }
        }
    }

    private void confirmDeletion(String lot_id){
        while (carDeletionProcess) {
            Vehicle v1 = lds.getVehicle(lot_id);
            System.out.println("You Are About To Delete: ");
            System.out.println("Make: " + v1.getMake() + ", Model: " + v1.getModel() + ", Year: " + v1.getYr() + ", MSRP: " + v1.getMsrp() + ", Color: " + v1.getColor());
            System.out.println("Enter 'confirm' to Confirm Deletion, or Enter 'b' To Go Back.");
            String response = scanner.nextLine();
            if (response.equals("b")) { break; }
            else if (response.equals("confirm")) {
                Lr.inst().log("Deleted Car of Lot_Id: " + lot_id);
                lds.deleteCar(lot_id);
                setCarDeletionProcess(false);
            }
        }
    }

    private boolean isValidLotId(String lot_id){
        try {
            Integer.parseInt(lot_id);
            if (!lds.doesCarExist(lot_id)){
                System.out.println("Car Does Not Exist");
                return false;
            }
        } catch (NumberFormatException e){
            System.out.println("Invalid Input (Must Be A Number)");
            return false;
        }
        return true;
    }

    public void setCarDeletionProcess(boolean carDeletionProcess) {
        this.carDeletionProcess = carDeletionProcess;
    }
}
