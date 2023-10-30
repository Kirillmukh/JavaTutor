package com.example.java_tutor.service;

import com.example.java_tutor.entity.Address;
import com.example.java_tutor.entity.AddressesList;
import com.example.java_tutor.exceptions.JSONException;

public interface JSONService {
    public AddressesList getAddresses(String json) throws JSONException;

    public Address getAddress(String json) throws JSONException;
}
