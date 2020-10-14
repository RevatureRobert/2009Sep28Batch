package com.car_dealership_cli.user_interface;

import java.util.List;
import java.util.Scanner;

import com.car_dealership_cli.dao.UserDAO;
import com.car_dealership_cli.model.User;
import com.car_dealership_cli.user_interface.interfaces.Menu;

public class ViewUsers implements Menu {
	Scanner input;
	
	boolean cont = false;
	@Override
	public void open(Scanner a) {
		this.input = a;
		do {
			display();
			select(input.next());
		}while(!cont);

	}

	@Override
	public void display() {
		UserDAO dao = new UserDAO();
		List<User> users = dao.findAll();
		for(int i = 0; i<users.size(); i++) {
			System.out.println(users.get(i));
		}

	}

	@Override
	public boolean select(String in) {
		// TODO Auto-generated method stub
		cont = true;
		return false;
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

}
