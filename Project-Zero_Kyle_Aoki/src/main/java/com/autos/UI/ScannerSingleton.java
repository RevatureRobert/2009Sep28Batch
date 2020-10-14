package com.autos.UI;

import java.util.Scanner;

public class ScannerSingleton {

    public static ScannerSingleton scan;
    private static Scanner scanner;

    public ScannerSingleton() {
        scanner = new Scanner(System.in);
    }
    public Scanner getScanner() {
        return scanner;
    }
    public static ScannerSingleton getInstance(){
        if(scan == null){
            scan = new ScannerSingleton();
        }
        return scan;
    }

}
