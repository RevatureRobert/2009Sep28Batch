package com.autos.UI.dashboards;

import com.autos.UI.ScannerSingleton;
import com.autos.utility.Lr;
import com.autos.controller.proccesses.CarDeletionProcess;
import com.autos.controller.proccesses.EmployeeFiringProcess;
import com.autos.controller.proccesses.AddCarToLotProcess;
import com.autos.controller.proccesses.OfferEvaluationProcess;
import com.autos.controller.viewers.*;
import com.autos.models.User;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ManagerDashboard {

    private final Scanner scanner = ScannerSingleton.getInstance().getScanner();
    private final HashMap<String, Runnable> commands = new HashMap<>();
    private boolean running = true;
    private Set<String> keySet;
    public User u1;

    public void loop(){
        this.buildCommandMap();
        System.out.println("Welcome, Manager");
        while (running) {
            UserContext.setUser(u1.getUsername());
            printManagerOptions();
            String command = scanner.nextLine();
            if (commandInKeySet(command)) commands.get(command).run();
        }
    }

    public void printManagerOptions(){
        System.out.println("Select An Option: ");
        System.out.println("(1) Add Car To Lot");
        System.out.println("(2) View Cars On Lot");
        System.out.println("(3) Remove Car From Lot");
        System.out.println("(4) Accept or Reject Offers");
        System.out.println("(5) View All Payments");
        System.out.println("(6) View Payments By Customer");
        System.out.println("(7) View Employee List");
        System.out.println("(8) Fire Employee");
        System.out.println("(9) View All Logs");
        System.out.println("(10) Push Logs To DB");
        System.out.println("(Q) Log Out");
    }

    private void buildCommandMap(){
        commands.put("1", this::_1);
        commands.put("2", this::_2 );
        commands.put("3", this::_3 );
        commands.put("4", this::_4 );
        commands.put("5", this::_5 );
        commands.put("6", this::_6 );
        commands.put("7", this::_7 );
        commands.put("8", this::_8 );
        commands.put("9", this::_9 );
        commands.put("10", this::_10 );
        commands.put("11", this::_11 );
        commands.put("Q", this::_Q );
        setKeySet(commands.keySet());
    }

    private void _1 () { new AddCarToLotProcess().startInformationCollection(); }
    private void _2 () { new LotViewer().view(); }
    private void _3 () { new CarDeletionProcess().deleteCar(); }
    private void _4 () { new OfferEvaluationProcess().evaluate(); }
    private void _5 () { new PaymentsViewer().view(); }
    private void _6 () { new CustomerPaymentsViewer().view(); }
    private void _7 () { new EmployeeViewer().view(); }
    private void _8 () { new EmployeeFiringProcess().fire(); }
    private void _9 () { new LogViewer().viewLogs(); }
    private void _10 () { Lr.push_logs_to_DB(); }
    private void _11 () { new Selector().enterDashboard(u1.getUsername(), false); }
    private void _Q () { UserContext.setUser(""); setRunning(false); }

    private boolean commandInKeySet(String response){
        for (String key : keySet) if (key.equals(response)) return true;
        return false;
    }

    public void setUser(User u1) { this.u1 = u1; }

    public void setKeySet(Set<String> keySet) { this.keySet = keySet; }

    public void setRunning(boolean running) { this.running = running; }

}
