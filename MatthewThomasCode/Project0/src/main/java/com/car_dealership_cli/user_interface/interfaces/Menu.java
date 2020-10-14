package com.car_dealership_cli.user_interface.interfaces;

import java.util.Scanner;

public interface Menu {

		public void open(Scanner a);
		
		public void display();
		
		public boolean select(String in);
		
		public void exit();

		
}
