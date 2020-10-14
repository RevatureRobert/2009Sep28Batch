package com.cars.ui;

public class TextEffects {

	//These are ansi codes, which allow you to add special effects to text in a console
	//I found these through the website below
	//https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	//credit to WhiteFang34 and SergeyB on StackOverflow
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";  //NOTE!  YELLOW AND BLUE DO NOT CURRENTLY HAVE REVERSED VALUES
	public static final String ANSI_BLUE = "\u001B[34m";    //THIS IS BECAUSE YOU CAN SEE YELLOW BETTER ON A BLACK BACKGROUND
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";	
	
}
