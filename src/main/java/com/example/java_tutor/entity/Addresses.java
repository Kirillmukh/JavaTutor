package com.example.java_tutor.entity;


import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Addresses {
    @Getter
    @Setter
    @JsonSetter("addresses")
    private List<Address> list;

}
