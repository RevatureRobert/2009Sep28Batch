package com.project.ui;

public class Printers {
	
	public static void blankPrinter() {		/* Prints a ton of blank lines */
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public static void mainMenuNonsense() {
		Printers.blankPrinter();
		System.out.println("                        __________________\r\n"
				+ "                      _/ ||                ~-_\r\n"
				+ "                    ,/   //       /~-       /  ~-_ "+TextColors.CYAN_BRIGHT+" ________----------//\r\n"
				+ "  -----------------/-----------------\\-------------------____________//\r\n"
				+ " O--------------  /               ~~^ |                             | ~|\r\n"
				+ " }======{--------\\____________________|_____________________________|  |\r\n"
				+ " \\===== / /~~~\\ \\ \\                   |         ____________________|-~\r\n"
				+ "  \\----"+TextColors.RESET+"|  \\___/ ||"+TextColors.CYAN_BRIGHT+"--------------------'----------"+TextColors.RESET+"|  \\____/ //\r\n"
				+ TextColors.GREEN_BRIGHT+" ______"+TextColors.RESET+"`.______.'"+TextColors.GREEN_BRIGHT+"________________________________"+TextColors.RESET+"`._______.'"+TextColors.GREEN_BRIGHT+"____________"+TextColors.RESET);
		for(int i = 0; i < 12; i++)
			System.out.print(TextColors.PURPLE_BOLD+"*"+TextColors.CYAN_BOLD+"*"+TextColors.BLUE_BOLD+"*"+TextColors.GREEN_BOLD+"*"+TextColors.YELLOW_BOLD+"*"+TextColors.RED_BOLD+"*");
		System.out.println(TextColors.PURPLE_BOLD+"*"+TextColors.YELLOW_BOLD+"\n            Welcome to Carlo's Used-Car Action-Auction Lot!");
		for(int i = 0; i < 12; i++)
			System.out.print(TextColors.PURPLE_BOLD+"*"+TextColors.CYAN_BOLD+"*"+TextColors.BLUE_BOLD+"*"+TextColors.GREEN_BOLD+"*"+TextColors.YELLOW_BOLD+"*"+TextColors.RED_BOLD+"*");
		System.out.print(TextColors.PURPLE_BOLD+"*"+TextColors.RESET+"\n");
	}
	
	public static void validInput() {
		
		// If input did satisfy conditions, display success
		blankPrinter();
		System.out.println(TextColors.GREEN_BOLD + "oOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOo");
		System.out.println("          Success! Returning to menu.");
		System.out.println("oOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOo" + TextColors.RESET);
		
		// Delay menu reset so user can read failure message
		System.out.print(TextColors.GREEN  + TextColors.GREEN_BACKGROUND_BRIGHT);
		loadingBar(15);
		System.out.print(TextColors.RESET);
	}
	
	public static void loadingTemplate(String str, int loadingSpeed) {
		
		// If input didn't satisfy conditions, bad input
		blankPrinter();
		System.out.println(TextColors.YELLOW_BOLD + "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/");
		System.out.println(str);
		System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\" + TextColors.RESET);
		
		// Delay menu reset so user can read failure message
		System.out.print(TextColors.YELLOW + TextColors.YELLOW_BACKGROUND_BRIGHT);
		loadingBar(loadingSpeed);
		System.out.print(TextColors.RESET);
		
	}
	
	public static void loading(String type) {
				
		String str;
		int loadingSpeed;
		switch(type) {
			case "search":
				str = "             Checking for record...";
				loadingSpeed = 13;
				break;
			case "create":
				str = "               Creating record...";
				loadingSpeed = 20;
				break;
			case "delete":
				str = "            Deleting from database...";
				loadingSpeed = 20;
				break;
			case "update":
				str = "               Updating Record...";
				loadingSpeed = 20;
				break;
			case "offer":
				str = "               Submitting Offer...";
				loadingSpeed = 20;
				break;
			case "offerAccept":
				str = "          Validating offer acceptance...";
				loadingSpeed = 20;
				break;
			case "payment":
				str = "              Processing payment...";
				loadingSpeed = 15;
				break;
			default:
				str = "Carlo misspelled something";
				loadingSpeed = 5;
		}
		loadingTemplate(str,loadingSpeed);

	}
	
	public static void invalidTemplate(String str, int loadingSpeed) {
		
		// If input didn't satisfy conditions, bad input
		blankPrinter();
		System.out.println(TextColors.RED_BOLD + "xXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXx");
		System.out.println(str);
		System.out.println("xXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXx" + TextColors.RESET);
		
		// Delay menu reset so user can read failure message
		System.out.print(TextColors.RED + TextColors.RED_BACKGROUND_BRIGHT);
		loadingBar(loadingSpeed);
		System.out.print(TextColors.RESET);
		
	}
	
	public static void invalid(String type) {
				
		String str;
		int loadingSpeed;
		switch(type) {
			case "input":
				str = "Sorry, we didn't understand you. Please try again.";
				loadingSpeed = 17;
				break;
			case "permission":
				str = "You don't have permission to access this menu.";
				loadingSpeed = 15;
				break;
			case "record":
				str = "      Record not found, please try again.";
				loadingSpeed = 15;
				break;
			case "duplicate":
				str = "Record already exists, please try different credentials.";
				loadingSpeed = 20;
				break;
				case "number":
				str = "Please do not enter non-numbers into a numbers field.";
				loadingSpeed = 20;
				break;
			case "payment":
				str = "            Please enter a valid amount.";
				loadingSpeed = 15;
				break;
			default:
				str = "Carlo misspelled something";
				loadingSpeed = 5;
		}
		invalidTemplate(str,loadingSpeed);

	}
	
	public static void loadingBar(int speed) {		// Loading bar included!
		try {						
			for(int i = 0; i<50; i++) {
				System.out.print(' ');
				Thread.sleep(speed);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void exitText() {
		blankPrinter();
		System.out.print(TextColors.YELLOW_BOLD);
		System.out.println("                                 _________\r\n"
				+ "                          _.--\"\"'-----,   `\"--.._\r\n"
				+ "                       .-''   _/_      ; .'\"----,`-,\r\n"
				+ "                     .'      :___:     ; :      ;;`.`.\r\n"
				+ "                    .      _.- _.-    .' :      ::  `..\r\n"
				+ "                 __;..----------------' :: ___  ::   ;;\r\n"
				+ "            .--\"\". '           ___.....`:=(___)-' :--'`.\r\n"
				+ "          .'   .'         .--''__       :       ==:    ;\r\n"
				+ "      .--/    /        .'.''     ``-,   :         :   '`-.\r\n"
				+ "   .\"', :    /       .'-`\\\\       .--.\\ :         :  ,   _\\\r\n"
				+ "  ;   ; |   ;       /:'  ;;      /__  \\\\:         :  :  /_\\\\\r\n"
				+ "  |\\_/  |   |      / \\__//      /\"--\\\\ \\:         :  : ;|`\\|    \r\n"
				+ "  : \"  /\\__/\\____//   \"\"\"      /     \\\\ :         :  : :|'||\r\n"
				+ "[\"\"\"\"\"\"\"\"\"--------........._  /      || ;      __.:--' :|//|\r\n"
				+ " \"------....______         ].'|      // |--\"\"\"'__...-'`\\ \\//\r\n"
				+ "   `| WVE230L |__;_...--'\": :  \\    //  |---\"\"\"      \\__\\_/\r\n"
				+ "     \"\"\"\"\"\"\"\"\"'            \\ \\  \\_.//  /\r\n"
				+ "       `---'                \\ \\_     _'\r\n"
				+ "                             `--`---'  ");
		System.out.print(TextColors.BLACK_BACKGROUND);
		for(int i = 0; i < 10; i++)
			System.out.print(TextColors.PURPLE_BOLD+"*"+TextColors.CYAN_BOLD+"*"+TextColors.BLUE_BOLD+"*"+TextColors.GREEN_BOLD+"*"+TextColors.YELLOW_BOLD+"*"+TextColors.RED_BOLD+"*");
		System.out.println(TextColors.PURPLE_BOLD+"*"+TextColors.YELLOW_BOLD+"\n   *    *    *    Thank you for visiting!    *    *    *     ");
		for(int i = 0; i < 10; i++)
			System.out.print(TextColors.PURPLE_BOLD+"*"+TextColors.CYAN_BOLD+"*"+TextColors.BLUE_BOLD+"*"+TextColors.GREEN_BOLD+"*"+TextColors.YELLOW_BOLD+"*"+TextColors.RED_BOLD+"*");
		System.out.print(TextColors.PURPLE_BOLD+"*"+TextColors.RESET);
	}

}
