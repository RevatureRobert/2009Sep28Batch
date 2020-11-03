package com.example.service;

import com.example.dao.*;
import com.example.model.Oven;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OvenService {

    private OvenDao odao;
    

    public OvenService(OvenDao udao) {
        this.odao = odao;
    }

    public OvenService() {
        this(new OvenDao());
    }

    public List<Oven> viewAllOvens(HttpServletResponse res) {
        return odao.findAll();
    }

    public void saveOven(HttpServletRequest req, HttpServletResponse res){

    }

}