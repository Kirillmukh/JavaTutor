package com.example.java_tutor.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Address {

    @Getter
    @Setter
    private String address;

    public Address(String address) {
        this.address = address;
    }
}
