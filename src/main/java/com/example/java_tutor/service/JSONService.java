package com.example.java_tutor.service;

import com.example.java_tutor.entity.Address;
import com.example.java_tutor.entity.Addresses;
import com.example.java_tutor.exceptions.JSONException;

public interface JSONService {
    public Addresses getAddresses(String json) throws JSONException;

    public Address getAddress(String json) throws JSONException;
}
