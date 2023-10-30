package com.example.java_tutor.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Data
public class Addresses {
    private LinkedList<Address> addresses;
}
