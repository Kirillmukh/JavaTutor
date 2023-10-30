package com.example.java_tutor.build;

import com.example.java_tutor.entity.Address;
import com.example.java_tutor.entity.Addresses;
import com.example.java_tutor.exceptions.HSSFWorkbookNotClosedException;
import com.example.java_tutor.exceptions.JSONException;
import com.example.java_tutor.exceptions.XLSXReadingException;
import com.example.java_tutor.service.AddressService;
import com.example.java_tutor.service.ExcelService;
import com.example.java_tutor.service.JSONService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacadeImpl implements Facade {

    @Autowired
    private JSONService jsonService;
    @Autowired
    private ExcelService excelService;
    @Autowired
    private AddressService addressService;

    @Override
    public List<Address> getAddress(final String json) throws JSONException, XLSXReadingException, HSSFWorkbookNotClosedException {
        Addresses addresses = jsonService.getAddresses(json);
        List<Address> oldAddresses = excelService.getAddresses();
        List<Address> newAddresses = addresses.getAddressesList();
        List<Address> addressList = addressService.getAddressesByLists(oldAddresses, newAddresses);
        excelService.sendAddresses(addressList);
        return addressList;

    }

    @Override
    public List<Address> removeAddress(final String json) throws JSONException, XLSXReadingException {
        Address address = jsonService.getAddress(json);
        List<Address> addressList = excelService.getAddresses();
        addressList.remove(address);
        return addressList;
    }
}
