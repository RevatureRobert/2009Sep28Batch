package com.example.service;

import com.example.dao.OvenDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OvenService {
    OvenDao ovenDao = new OvenDao();
    public String getAll() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(ovenDao.findAll());
    }
}
