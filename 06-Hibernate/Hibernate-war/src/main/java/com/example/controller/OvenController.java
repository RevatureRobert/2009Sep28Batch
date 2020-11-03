package com.example.controller;

import com.example.service.OvenService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OvenController {
    OvenService ovenService = new OvenService();

    public void getAllOven(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getMethod().toLowerCase().equals("get")) {
            resp.setContentType("text/json");
            try {
                resp.getWriter().println(ovenService.getAll());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            resp.sendError(400);
        }
    }
}
