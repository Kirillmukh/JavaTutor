package com.example.java_tutor.file_service;

import com.example.java_tutor.JavaTutorApplication;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class TargetDirectory {

    private TargetDirectory() {}

    public static String getClassesPath() throws URISyntaxException {
        URL url = JavaTutorApplication.class.getProtectionDomain().getCodeSource().getLocation();
        return Paths.get(url.toURI()).toString();
    }

    public static String getTargetPath() throws URISyntaxException {
        String filePath = getClassesPath();
        return filePath.substring(0, 1 + filePath.lastIndexOf("/"));
    }
}
