package com.carsales.menu;

public class MenuPrint {
	
	private static MenuPrint instance = null;
	
	private MenuPrint()
	{
		super();
	}
	
	public static MenuPrint getInstance()
	{
		if(instance == null)
			instance = new MenuPrint();
		
		return instance;
	}
	
	public static void MainMenu()
	{
			System.out.println("Welcome to the Car Lot! \n"
					+ "\nPlease Enter Selection:\n"
					+ "1)Login to my Account\n"
					+ "2)Register for an Account \n"
					+ "3)Exit \n");
	}

}
