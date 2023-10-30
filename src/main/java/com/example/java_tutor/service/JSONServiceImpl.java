package com.example.java_tutor.service;

import com.example.java_tutor.entity.Address;
import com.example.java_tutor.entity.AddressesList;
import com.example.java_tutor.exceptions.JSONException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JSONServiceImpl implements JSONService {
    @Override
    public AddressesList getAddresses(String json) throws JSONException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, AddressesList.class);
        } catch (JsonProcessingException e) {
            throw new JSONException(e);
        }
    }

    @Override
    public Address getAddress(String json) throws JSONException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, Address.class);
        } catch (JsonProcessingException e) {
            throw new JSONException(e);
        }
    }
}
