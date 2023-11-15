package com.example.java_tutor.service;

import com.example.java_tutor.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> mergeLists(List<Address> list1, List<Address> list2);
    List<Address> deleteAddress(List<Address> list, Address address);
}
