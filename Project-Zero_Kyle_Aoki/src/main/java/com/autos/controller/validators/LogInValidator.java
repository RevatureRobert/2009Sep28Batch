package com.autos.controller.validators;

import com.autos.service.UsersService;

public class LogInValidator {

    private static final UsersService uds = new UsersService();

    public boolean validate(String username, String pw){
        return uds.validateUser(username, pw);
    }

}
