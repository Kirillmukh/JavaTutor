package com.example.java_tutor.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class SingletonArray {

    @Getter
    @Setter
    private LinkedList<Address> array;

    private static SingletonArray instance;

    private SingletonArray() {
        array = new LinkedList<>();
    }

    public static SingletonArray getInstance() {
        if (instance == null) {
            instance = new SingletonArray();
        }
        return instance;
    }

}
