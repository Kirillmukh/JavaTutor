package com.example.java_tutor.service;

import com.example.java_tutor.entity.Address;
import com.example.java_tutor.exceptions.HSSFWorkbookNotClosedException;
import com.example.java_tutor.exceptions.XLSXReadingException;

import java.util.List;

public interface ExcelService {
    List<Address> getAddresses() throws XLSXReadingException;
    void sendAddresses(List<Address> list) throws HSSFWorkbookNotClosedException;
}
