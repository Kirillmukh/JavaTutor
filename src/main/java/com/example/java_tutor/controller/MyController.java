package com.example.java_tutor.controller;

import com.example.java_tutor.JavaTutorApplication;
import com.example.java_tutor.entity.Address;
import com.example.java_tutor.entity.Addresses;
import com.example.java_tutor.file_service.JarFile;
import com.example.java_tutor.service.AddressService;
import com.example.java_tutor.service.ExcelService;
import com.example.java_tutor.service.JSONService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.LinkedList;

@RestController
public class MyController {

    @Autowired
    private JSONService jsonService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ExcelService excelService;

    @PostMapping("/addresses")
    public LinkedList<Address> getAddress(@RequestBody String json) {
        try {
            Addresses addresses = jsonService.getAddresses(json);
            LinkedList<Address> oldAddresses = excelService.getAddresses();
            LinkedList<Address> newAddresses = addresses.getAddresses();
            LinkedList<Address> addressList = addressService.getAddressesByLists(oldAddresses, newAddresses);
            excelService.sendAddresses(addressList);
            return addressList;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                System.out.println(JarFile.getDirectoryPath(JavaTutorApplication.class));
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PostMapping("/addresses/delete")
    public LinkedList<Address> removeAddress(@RequestBody String json) {
        try {
            Address address = jsonService.getAddress(json);
            LinkedList<Address> addressList = excelService.getAddresses();
            addressList.remove(address);
            return addressList;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
