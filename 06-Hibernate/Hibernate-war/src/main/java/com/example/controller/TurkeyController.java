package com.example.controller;

import com.example.service.TurkeyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TurkeyController {

    TurkeyService turkeyService = new TurkeyService();

    public void getAllTurkey(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getMethod().toLowerCase().equals("get")) {
            resp.setContentType("text/json");
            try {
                resp.getWriter().println(turkeyService.getAll());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            resp.sendError(400);
        }
    }
}
