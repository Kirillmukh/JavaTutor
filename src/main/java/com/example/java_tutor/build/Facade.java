package com.example.java_tutor.build;

import com.example.java_tutor.entity.Address;
import com.example.java_tutor.entity.Addresses;
import com.example.java_tutor.service.AddressService;
import com.example.java_tutor.service.ExcelService;
import com.example.java_tutor.service.JSONService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class Facade {

    private final JSONService jsonService;
    private final ExcelService excelService;
    private final AddressService addressService;

    public Facade(JSONService jsonService, ExcelService excelService, AddressService addressService) {
        this.jsonService = jsonService;
        this.excelService = excelService;
        this.addressService = addressService;
    }

    public LinkedList<Address> getAddress(final String json) {
        try {
            Addresses addresses = jsonService.getAddresses(json);
            LinkedList<Address> oldAddresses = excelService.getAddresses();
            LinkedList<Address> newAddresses = addresses.getAddresses();
            LinkedList<Address> addressList = addressService.getAddressesByLists(oldAddresses, newAddresses);
            excelService.sendAddresses(addressList);
            return addressList;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Address> removeAddress(final String json) {
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
