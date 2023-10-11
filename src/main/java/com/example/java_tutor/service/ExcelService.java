package com.example.java_tutor.service;

import com.example.java_tutor.entity.Address;
import com.example.java_tutor.entity.SingletonExcel;
import org.apache.poi.EmptyFileException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ExcelService {

    @Autowired
    private SingletonExcel singletonExcel;


    public LinkedList<Address> getAddresses() {
        LinkedList<Address> linkedList = new LinkedList<>();
        try (HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(singletonExcel.getPath()))) {
            HSSFSheet sheet = workbook.getSheet(singletonExcel.getSheetName());
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                Address address = new Address(cell.getStringCellValue());
                linkedList.add(address);
            }
        } catch (EmptyFileException e) {
            return new LinkedList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return linkedList;
    }

    public void sendAddresses(LinkedList<Address> linkedList) {
        try (HSSFWorkbook workbook = new HSSFWorkbook()) {
            HSSFSheet sheet = workbook.createSheet(singletonExcel.getSheetName());
            AtomicInteger i = new AtomicInteger();
            linkedList.forEach(address -> {
                Row row = sheet.createRow(i.getAndIncrement());
                Cell cell = row.createCell(0);
                cell.setCellValue(address.getAddress());
            });
            FileOutputStream fileOutputStream = new FileOutputStream(singletonExcel.getPath());
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
