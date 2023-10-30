package com.example.java_tutor.service;

import com.example.java_tutor.entity.Address;
import com.example.java_tutor.entity.SingletonExcel;
import com.example.java_tutor.exceptions.HSSFWorkbookNotClosedException;
import com.example.java_tutor.exceptions.XLSXReadingException;
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
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private SingletonExcel singletonExcel;

    @Override
    public List<Address> getAddresses() throws XLSXReadingException {
        LinkedList<Address> linkedList = new LinkedList<>();
        try (HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(singletonExcel.getAbsolutePath()))) {
            HSSFSheet sheet = workbook.getSheet(singletonExcel.getSheetName());
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                Address address = new Address(cell.getStringCellValue());
                linkedList.add(address);
            }
        } catch (EmptyFileException e) {
            return new LinkedList<>();
        } catch (IOException e) {
            throw new XLSXReadingException(e);
        }
        return linkedList;
    }

    @Override
    public void sendAddresses(List<Address> list) throws HSSFWorkbookNotClosedException {
        try (HSSFWorkbook workbook = new HSSFWorkbook()) {
            HSSFSheet sheet = workbook.createSheet(singletonExcel.getSheetName());
            AtomicInteger i = new AtomicInteger();
            list.forEach(address -> {
                Row row = sheet.createRow(i.getAndIncrement());
                Cell cell = row.createCell(0);
                cell.setCellValue(address.getAddress());
            });
            FileOutputStream fileOutputStream = new FileOutputStream(singletonExcel.getAbsolutePath());
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            throw new HSSFWorkbookNotClosedException(e);
        }
    }
}
