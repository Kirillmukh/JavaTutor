package com.example.java_tutor.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Address {

    private String address;

    public Address(String address) {
        this.address = address;
    }
}
