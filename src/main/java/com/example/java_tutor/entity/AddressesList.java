package com.example.java_tutor.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
public class AddressesList {
    @Getter
    @Setter
    private List<Address> addresses;

    public AddressesList(List<Address> addresses) {
        this.addresses = addresses;
    }
}
