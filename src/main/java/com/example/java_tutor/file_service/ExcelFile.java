package com.example.java_tutor.file_service;

import com.example.java_tutor.exceptions.HSSFWorkbookNotClosedException;
import com.example.java_tutor.exceptions.XLSXNotCreatedException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFile {

    private final static String SEPARATOR = "/";

    private ExcelFile() {
    }

    public static boolean exists(String path, String fileName) {
        File file = new File(path + fileName + ".xlsx");
        return file.exists();
    }

    public static void create(String path, String fileName, String sheetName) throws XLSXNotCreatedException, HSSFWorkbookNotClosedException {
        try (HSSFWorkbook workbook = new HSSFWorkbook()) {
            workbook.createSheet(sheetName);
            FileOutputStream out = new FileOutputStream(new File(path + SEPARATOR + fileName + ".xlsx"));
            workbook.write(out);
        } catch (IOException e) {
            throw new XLSXNotCreatedException(e);
        } catch (Exception e) {
            throw new HSSFWorkbookNotClosedException(e);
        }
    }
}
