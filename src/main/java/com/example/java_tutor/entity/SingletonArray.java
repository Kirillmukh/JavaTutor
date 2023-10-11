package com.example.java_tutor.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
@Scope("singleton")
public class SingletonArray {

    @Getter
    @Setter
    private LinkedList<Address> array;

    private static SingletonArray instance;

    private SingletonArray() {
        array = new LinkedList<>();
    }

    public static synchronized SingletonArray getInstance() {
        if (instance == null) {
            instance = new SingletonArray();
        }
        return instance;
    }

}
