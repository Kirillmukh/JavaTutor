package com.example.java_tutor.controller;

import com.example.java_tutor.entity.Address;
import com.example.java_tutor.build.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class MyController {

    @Autowired
    private Facade facade;

    @PostMapping("/addresses")
    public LinkedList<Address> getAddress(@RequestBody String json) {
        return facade.getAddress(json);
    }

    @PostMapping("/addresses/delete")
    public LinkedList<Address> removeAddress(@RequestBody String json) {
        return facade.removeAddress(json);
    }
}
