
package com.autos.driver;

import com.autos.UI.ScannerSingleton;
import com.autos.UI.WelcomeMenu;
import com.autos.UI.dashboards.UserContext;
import com.autos.repository.ConnectionSingleton;

import java.sql.SQLException;

public class Driver {
    public static void main(String[] args) {
        WelcomeMenu wp = new WelcomeMenu();
        wp.startProgram();
        
        closeProgram();
    }
    public static void closeProgram(){
        UserContext.setUser("");
        ScannerSingleton.getInstance().getScanner().close();
        try {
            ConnectionSingleton.getInstance().getConn().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

// project requirements
/*
 
  # Car Dealership
 
  ## Description
 
     The Car Dealership app is a console-based application that facilitates the purchasing of cars.
     An employee can add cars to the lot and manage offers for those cars, while a customer can view the cars on the lot and make offers.
 
  ## Purpose
 
     We want to see that you can meet deadlines and that you can code.
     You are expected to complete the following requirements and give a 5 minute presentation of your project to our QC team.
 
  ## Requirements
  1. Functionality should reflect the below user stories.                                                      x
  2. Data is stored in a database.                                                                             x
  3. A custom stored procedure is called to perform some portion of the functionality.                         x
  4. Data Access is performed through the use of JDBC in a data layer consisting of Data Access Objects.       x
  5. All input is received using the java.util.Scanner class.                                                  x
  6. Log4j is implemented to log events to a file.                                                             x
  7. A minimum of one (1) JUnit test is written to test some functionality.                                    x
 
 
  ## User Stories
 
  * As a user, I can log in.                                                                                   x
  * As an employee, I can add a car to the lot.                                                                x
  * As a customer, I can view the cars on the lot.                                                             x
  * As a customer, I can make an offer for a car.                                                              x
  * As an employee, I can accept or reject an offer for a car.                                                 x
  * As the system, I reject all other pending offers for a car when an offer is accepted.                      x
  * As a user, I can register for a customer account.                                                          x
  * As an employee, I can remove a car from the lot.                                                           x
  * As a customer, I can view the cars that I own.                                                             x
  * As a customer, I can view my remaining payments for a car.                                                 x
  * As an employee, I can view all payments.                                                                   x
  * As the system, I can calculate the monthly payment.                                                        x
 
 */