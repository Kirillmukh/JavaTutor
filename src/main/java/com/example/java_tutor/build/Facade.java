package com.example.java_tutor.build;

import com.example.java_tutor.entity.Address;
import com.example.java_tutor.exceptions.HSSFWorkbookNotClosedException;
import com.example.java_tutor.exceptions.JSONException;
import com.example.java_tutor.exceptions.XLSXReadingException;

import java.util.List;

public interface Facade {
    public List<Address> getAddress(final String json) throws JSONException, XLSXReadingException, HSSFWorkbookNotClosedException;
    public List<Address> removeAddress(final String json) throws JSONException, XLSXReadingException;
}
