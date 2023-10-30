package com.example.java_tutor.entity;

import com.example.java_tutor.build.BuildService;
import com.example.java_tutor.exceptions.HSSFWorkbookNotClosedException;
import com.example.java_tutor.exceptions.XLSXNotCreatedException;
import com.example.java_tutor.file_service.ExcelFile;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

@Component
public class SingletonExcel {
    @Getter
    private final String absolutePath;
    @Getter
    @Setter
    private String fileName;
    @Getter
    @Setter
    private String sheetName;
    private static SingletonExcel instance;

    private SingletonExcel() throws URISyntaxException, XLSXNotCreatedException, HSSFWorkbookNotClosedException {
        sheetName = "sheet1";
        fileName = "addresses";
        String path = BuildService.getPath();
        if (!ExcelFile.exists(path, fileName)) {
            ExcelFile.create(path, fileName, sheetName);
        }
        absolutePath = path + fileName + ".xlsx";

    }

    public static SingletonExcel getInstance() throws XLSXNotCreatedException, HSSFWorkbookNotClosedException, URISyntaxException {
        if (instance == null) {
            instance = new SingletonExcel();
        }
        return instance;
    }
}
