package com.example.Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.OvenDao;
import com.example.dao.TurkeyDao;
import com.example.model.Oven;
import com.example.service.OvenService;
import com.example.service.TurkeyService;
import com.fasterxml.jackson.databind.ObjectMapper;


public class RequestForwarder {
	
    OvenDao od = new OvenDao();
    TurkeyDao td = new TurkeyDao();
    ObjectMapper om = new ObjectMapper();

    public void data(HttpServletRequest req, HttpServletResponse res) throws Exception {
        System.out.println("Path Info: " + req.getPathInfo());
        System.out.println("Request URI: " + req.getRequestURI());
        switch(req.getRequestURI()){
        case "/Hibernate-war/saveOven.json":
            Oven o = om.readValue(req.getInputStream(), Oven.class);
            od.save(o);
            break;
        case "/Hibernate-war/findAllOvens.json":
        	 System.out.println("Path Info: " + req.getPathInfo());
             System.out.println("Request URI: " + req.getRequestURI());
             res.getWriter().println(od.findAll());
             //res.getWriter().println(om.writeValueAsString(od.findAll()));

            break;
        case "/Hibernate-war/findOven":

            break;
        case "/Hibernate-war/updateOven":

            break;
        case "/Hibernate-war/deleteOven":

            break;
        case "/Hibernate-war/addTurkey":

            break;
        case "/Hibernate-war/findTurkey":

            break;
        case "/Hibernate-war/findTurkeyByName":

            break;
        case "/Hibernate-war/findAllTurkey":

            break;
        case "/Hibernate-war/updateTurkey":

            break;
        case "/Hibernate-war/deleteTurkey":

            break;
        }

    }

}