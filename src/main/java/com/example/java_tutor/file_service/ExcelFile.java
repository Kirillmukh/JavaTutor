package com.example.java_tutor.file_service;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

public class ExcelFile {
    public static boolean exists(String path, String fileName) throws URISyntaxException {
        File file = new File(path + fileName + ".xlsx");
        return file.exists();
    }

    public static void create(String path, String fileName, String sheetName) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);
        try (FileOutputStream out = new FileOutputStream(new File(path + "/" + fileName + ".xlsx"))) {
            workbook.write(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("file was created");
    }
}
