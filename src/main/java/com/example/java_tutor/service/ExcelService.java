package com.example.java_tutor.service;

import com.example.java_tutor.entity.Address;
import com.example.java_tutor.exceptions.HSSFWorkbookNotClosedException;
import com.example.java_tutor.exceptions.XLSXReadingException;

import java.util.List;

public interface ExcelService {
    public List<Address> getAddresses() throws XLSXReadingException;
    public void sendAddresses(List<Address> list) throws HSSFWorkbookNotClosedException;
}
