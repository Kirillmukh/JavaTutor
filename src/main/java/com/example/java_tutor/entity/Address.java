package com.example.java_tutor.entity;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Getter
    @Setter
    @JsonSetter("address")
    private String value;
}
