package com.example.java_tutor.entity;

import com.example.java_tutor.JavaTutorApplication;
import com.example.java_tutor.build.BuildService;
import com.example.java_tutor.file_service.ExcelFile;
import com.example.java_tutor.file_service.JarFile;
import com.example.java_tutor.file_service.TargetDirectory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

@Component
public class SingletonExcel {
    @Getter
    private final String path;
    @Getter
    @Setter
    private String fileName;
    @Getter
    @Setter
    private String sheetName;
    private static SingletonExcel instance;

    private SingletonExcel() {
        sheetName = "sheet1";
        fileName = "addresses";
        try {
            String path = BuildService.getPath();
            if (!ExcelFile.exists(path, fileName)) {
                ExcelFile.create(path, fileName, sheetName);
            }
            this.path = path + fileName + ".xlsx";

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static SingletonExcel getInstance() {
        if (instance == null) {
            instance = new SingletonExcel();
        }
        return instance;
    }
}
