package com.dealership;

import java.util.Scanner;

import com.dealership.dao.DealershipDAO;
import com.dealership.dao.DealershipMasterDAO;
import com.dealership.frontend.ViewMaster;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		DealershipDAO dao = new DealershipMasterDAO();
		
		// TOP LEVEL EXCEPTION HANDLER AND RESOURCE CLOSER
		try {
			ViewMaster vm = ViewMaster.initialize(s, dao);
			
			vm.runViewSelector();
		}
		catch(Exception e) {
			e.printStackTrace();
			
			System.out.println("\n\nA problem occurred, and the program must exit!\n\n");
		}
		finally {
			s.close();
			dao.closeAllConnections();
			
			System.out.println("Program closed!");
		}
	}
}