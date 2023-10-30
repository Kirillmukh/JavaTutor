package com.example.java_tutor.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
public class Address {

    private String address;

    public Address(String address) {
        string = address;
    }
}
