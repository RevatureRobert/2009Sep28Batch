package com.example.service;

import com.example.dao.TurkeyDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TurkeyService {
    TurkeyDao turkeyDao = new TurkeyDao();
    public String getAll() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(turkeyDao.findAll());
    }
}
