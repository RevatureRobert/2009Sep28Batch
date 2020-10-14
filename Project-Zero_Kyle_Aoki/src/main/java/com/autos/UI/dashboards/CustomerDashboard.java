package com.autos.UI.dashboards;

import com.autos.UI.ScannerSingleton;
import com.autos.controller.proccesses.MakeOfferProcess;
import com.autos.controller.proccesses.PaymentProcess;
import com.autos.controller.viewers.LotViewer;
import com.autos.controller.viewers.MyCarsViewer;
import com.autos.controller.viewers.MyOffersViewer;
import com.autos.models.User;

import java.util.Set;
import java.util.HashMap;
import java.util.Scanner;

public class CustomerDashboard {

    private boolean running = true;
    private final Scanner scanner = ScannerSingleton.getInstance().getScanner();
    private final HashMap<String, Runnable> commands = new HashMap<>();
    private Set<String> keySet;
    public User u1;

    public void setUser(User u1) {
        this.u1 = u1;
    }

    public void setKeySet(Set<String> keySet) {
        this.keySet = keySet;
    }

    public void loop(){
        this.buildCommandMap();
        while (running) {
            this.printDashboardOptions();
            String command = scanner.nextLine();
            if (this.commandInKeySet(command)) commands.get(command).run();
        }
    }

    private void buildCommandMap() {
        this.commands.put("1", this::_1 );
        this.commands.put("2", this::_2 );
        this.commands.put("3", this::_3 );
        this.commands.put("4", this::_4 );
        this.commands.put("5", this::_5 );
        this.commands.put("Q", this::_Q );
        this.setKeySet(commands.keySet());
    }

    private void _1 () { new LotViewer().view(); }
    private void _2 () { new MakeOfferProcess().offerProcess(u1.getUsername()); }
    private void _3 () { new MyOffersViewer().view(u1.getUsername()); }
    private void _4 () { new MyCarsViewer().view(u1.getUsername()); }
    private void _5 () { new PaymentProcess().pay(u1.getUsername()); }
    private void _Q () { UserContext.setUser(""); setRunning(false); }

    public void printDashboardOptions(){
        System.out.println("Select An Option: ");
        System.out.println("(1) View Cars On Lot");
        System.out.println("(2) Make An Offer On a Car");
        System.out.println("(3) View My Offers");
        System.out.println("(4) View Cars Owned By Me");
        System.out.println("(5) Make A Payment");
        System.out.println("(Q) Log Out");
    }

    private boolean commandInKeySet(String response){
        for (String key : keySet) if (key.equals(response)) return true;
        return false;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
