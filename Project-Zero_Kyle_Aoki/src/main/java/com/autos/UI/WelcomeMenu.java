package com.autos.UI;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class WelcomeMenu {

	private boolean running = true;
	private final Scanner scanner = ScannerSingleton.getInstance().getScanner();
	private final HashMap<String, Runnable> commands = new HashMap<>();
	private Set<String> keySet;

    public void startProgram() {
        this.welcome();
        this.buildCommandMap();
        while (running) {
            this.welcomeSelection();
            String userInput = scanner.nextLine();
            if (this.isValidCommand(userInput)) this.commands.get(userInput).run();
        }
    }

    public void welcomeSelection() {
        System.out.println("Select: ");
        System.out.println("(1) Log In");
        System.out.println("(2) Create Account");
        System.out.println("(E) Exit the Program");
    }

    private void buildCommandMap() {
        this.commands.put("1", this::_1);
        this.commands.put("2", this::_2);
		this.commands.put("E", () -> setRunning(false));
		this.setKeySet(this.commands.keySet());
	}

	private void _1 () { new LogInMenu().logIn(); }
	private void _2 () { new AccountCreationPage().createAccountInitialPrompt(); }

	public void welcome() {
		System.out.println("|==================|");
		System.out.println("|   Welcome To     |");
		System.out.println("|    Aoki Auto     |");
		System.out.println("|     Company	   |");
		System.out.println("|==================|");
	}

	private boolean isValidCommand(String response){
		for (String key : keySet) if (response.equals(key)) return true;
		return false;
	}

	public void setKeySet(Set<String> keySet) { this.keySet = keySet; }

	public void setRunning(boolean running) { this.running = running; }

}
