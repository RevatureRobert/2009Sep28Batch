package com.autos.controller.validators;

import com.autos.service.UsersService;

import java.util.HashMap;

public class AccountCreationValidator {

    private static final String[] illegalStrings = {"username", "passw", "accounttype"};
    private final UsersService uds = new UsersService();

    public String validateAccountCreationInfo(HashMap<String, String> userInfo) {

        for (String key : userInfo.keySet()){
            for (String illegalString : illegalStrings){
                if (userInfo.get(key).equals(illegalString)){
                    return "Illegal Word Used for " + key;
                }
            }
        }

        for (String key : userInfo.keySet()){
            if (userInfo.get(key).length() > 35){
                return capitalize(key) + " is too long (must be shorter than 35 characters)";
            }
        }

        if (!userInfo.get("password").equals(userInfo.get("password confirmation"))){
            return "Passwords Do Not Match";
        }

        if (uds.doesUserExist(userInfo.get("username"))){
            return "Username is Taken";
        }

        return "Good To Go";
    }

    private String capitalize(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

}
