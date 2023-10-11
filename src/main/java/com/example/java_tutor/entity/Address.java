package com.example.java_tutor.entity;

import lombok.Data;


@Data
public class Address {

    private String address;

    public Address(String address) {
        this.address = address;
    }
    public Address() {}

}
