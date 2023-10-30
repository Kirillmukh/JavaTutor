package com.example.java_tutor.file_service;

import com.example.java_tutor.JavaTutorApplication;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class TargetDirectory {
    public static String getClassesPath(Class clazz) throws URISyntaxException {
        URL url = clazz.getProtectionDomain().getCodeSource().getLocation();
        return Paths.get(url.toURI()).toString();
    }

    public static String getTargetPath(Class clazz) throws URISyntaxException {
        String filePath = getClassesPath(clazz);
        return filePath.substring(0, 1 + filePath.lastIndexOf("/"));
    }
}
