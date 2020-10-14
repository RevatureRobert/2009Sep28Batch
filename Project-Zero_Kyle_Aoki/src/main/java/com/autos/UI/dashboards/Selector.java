package com.autos.UI.dashboards;

import com.autos.service.UsersService;
import com.autos.models.User;

public class Selector {

    private final UsersService uds = new UsersService();

    public void enterDashboard(String username, boolean normalMode){
        User u1 = uds.getUser(username);
        if (normalMode) {
            String accounttype = u1.getAccounttype();
            switch (accounttype) {
                case "Manager":
                    ManagerDashboard md = new ManagerDashboard();
                    md.setUser(u1);
                    md.loop();
                    break;
                case "Employee":
                    EmployeeDashboard ed = new EmployeeDashboard();
                    ed.setUser(u1);
                    ed.loop();
                    break;
                case "Customer":
                    CustomerDashboard cd = new CustomerDashboard();
                    cd.setUser(u1);
                    cd.loop();
                    break;
            }
        } else {
            System.out.println("----------WELCOME TO CUSTOMER MODE----------");
            CustomerDashboard cd = new CustomerDashboard();
            cd.setUser(u1);
            cd.loop();
        }
    }

}
