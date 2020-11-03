package com.example.service;

import com.example.dao.*;
import com.example.model.Turkey;

import java.util.*;

public class TurkeyService {

    private TurkeyDao odao;

    public TurkeyService(TurkeyDao udao) {
        this.odao = odao;
    }

    public TurkeyService() {
        this(new TurkeyDao());
    }

    public List<Turkey> viewAllTurkeys() {
        return odao.findAll();
    }

}