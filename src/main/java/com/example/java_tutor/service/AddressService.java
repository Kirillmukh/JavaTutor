package com.example.java_tutor.service;

import com.example.java_tutor.entity.Address;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.stream.Collectors;

@Service
public class AddressService {
    public LinkedList<Address> getAddressesByLists(LinkedList<Address> list1, LinkedList<Address> list2) {
        LinkedList<Address> templateList = (LinkedList<Address>) list1.clone();
        templateList.addAll(list2);
        templateList = templateList.stream()
                .distinct()
                .filter(address -> address != null)
                .filter(address -> address.getAddress() != null)
                .collect(Collectors.toCollection(LinkedList::new));
        return templateList;
    }

    public LinkedList<Address> deleteAddress(LinkedList<Address> addresses, Address address) {
        addresses.remove(address);
        return addresses;
    }
}
