package com.autos.controller.validators;

import com.autos.models.Vehicle;

import java.util.HashMap;

public class NewCarValidator {

    public boolean validate(Vehicle v1){

        try {
            Integer.parseInt(v1.getYr());
        } catch (NumberFormatException e) {
            System.out.println("Year is not an Integer");
            return false;
        }

        try {
            Double.parseDouble(v1.getMsrp());
        } catch (NumberFormatException e) {
            System.out.println("MSRP not an Double");
            return false;
        }

        HashMap<String, String> carInfo = new HashMap<>();

        carInfo.put("make", v1.getMake());
        carInfo.put("model", v1.getModel());
        carInfo.put("yr", v1.getYr());
        carInfo.put("msrp", v1.getMsrp());
        carInfo.put("color", v1.getColor());

        for (String key : carInfo.keySet()){
            if (carInfo.get(key).length() > 35){
                System.out.println("Input for '" + key + "' is too long. (1 < x < 35)");
                return false;
            } else if (carInfo.get(key).length() < 1) {
                System.out.println("Input for '" + key + "' is too short. (1 < x < 35)");
                return false;
            }
        }

        return true;
    }

}
