package com.example.controller;

import com.example.model.Oven;
import com.example.service.OvenService;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public void createOven(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getMethod().toLowerCase().equals("post")) {
            Oven oven = new ObjectMapper().readValue(req.getInputStream(), Oven.class);
            if (ovenService.create(oven) != null) {
                resp.sendError(406, "Unable to create account");
            } else {
                System.out.println(oven);
            }
        } else {
            resp.sendError(400);
        }
    }

}
