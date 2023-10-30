package com.example.java_tutor.controller;

import com.example.java_tutor.build.Facade;
import com.example.java_tutor.entity.Address;
import com.example.java_tutor.exceptions.HSSFWorkbookNotClosedException;
import com.example.java_tutor.exceptions.JSONException;
import com.example.java_tutor.exceptions.XLSXReadingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private Facade facade;

    @PostMapping("/addresses")
    public List<Address> getAddress(@RequestBody String json) throws XLSXReadingException, HSSFWorkbookNotClosedException, JSONException {
        return facade.getAddress(json);
    }

    @PostMapping("/addresses/delete")
    public List<Address> removeAddress(@RequestBody String json) throws XLSXReadingException, JSONException {
        return facade.removeAddress(json);
    }
}
