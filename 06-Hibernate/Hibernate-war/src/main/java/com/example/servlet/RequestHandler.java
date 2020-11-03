package com.example.servlet;

import com.example.controller.OvenController;
import com.example.controller.TurkeyController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestHandler {

    public void data(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        String regex = "/turkey";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(uri);
        uri = m.replaceAll("");
        switch (uri){
            case "/api/allOven.json":
                new OvenController().getAllOven(req,resp);
                break;
            case "/api/allTurkey.json":
                new TurkeyController().getAllTurkey(req,resp);
                break;
            case "/api/createOven.json":
                new OvenController().createOven(req,resp);
                break;
            case "/api/createTurkey.json":
                new TurkeyController().createTurkey(req,resp);
                break;
        }
    }
}
