package com.autos.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;

public class Utils {

    public static void printTable(ResultSet resultSet){
        try {
            StringBuilder columnNames = new StringBuilder();
            int columnWidth = 20;
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            for (int i = 1; i <= columnsNumber; i++) {
                int colLength = rsmd.getColumnName(i).length();
                columnNames.append(rsmd.getColumnName(i).toUpperCase());
                columnNames.append(addSpaces(columnWidth - colLength));
            }
            System.out.println(columnNames);
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = resultSet.getObject(i).toString();
                    String columnPrintOut = columnValue + addSpaces(columnWidth - columnValue.length());
                    System.out.print(columnPrintOut);
                }
                System.out.println();
            }
        } catch (SQLException throwables) {
            System.out.println("Failed Print");
            throwables.printStackTrace();
        }
    }

    public static void printTable(HashMap<String, String> offerDetails){
        StringBuilder columnNames = new StringBuilder();
        int columnWidth = 20;
        for (String key : offerDetails.keySet()) {
            int colLength = key.length();
            columnNames.append(key.toUpperCase());
            columnNames.append(addSpaces(columnWidth - colLength));
        }
        System.out.println(columnNames);
        for (String key : offerDetails.keySet()) {
            String columnValue = offerDetails.get(key);
            String columnPrintOut = columnValue + addSpaces(columnWidth - columnValue.length());
            System.out.print(columnPrintOut);
        }
        System.out.println();
    }

    public static String addSpaces(int x){
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < x; i++){
            spaces.append(" ");
        }
        return spaces.toString();
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
