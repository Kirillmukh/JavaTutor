package com.example.java_tutor.service;

import com.example.java_tutor.entity.Address;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Override
    public List<Address> mergeLists(List<Address> list1, List<Address> list2) {
        List<Address> templateList = new LinkedList<>(list1);
        templateList.addAll(list2);
        List<String> strings = templateList.stream()
                .filter(Objects::nonNull)
                .map(Address::getValue)
                .filter(Objects::nonNull)
                .distinct()
                .toList();
        return getAddressesListByStrings(strings);
    }

    @Override
    public List<Address> deleteAddress(List<Address> addresses, Address address) {
        List<String> strings = addresses.stream().map(Address::getValue).collect(Collectors.toList());
        strings.remove(address.getValue());
        return getAddressesListByStrings(strings);
    }

    private static List<Address> getAddressesListByStrings(List<String> strings) {
        List<Address> result = new LinkedList<>();
        strings.forEach(string -> result.add(new Address(string)));
        return result;
    }
}
