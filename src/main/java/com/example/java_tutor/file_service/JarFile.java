package com.example.java_tutor.file_service;

import com.example.java_tutor.JavaTutorApplication;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class JarFile {

    private JarFile() {}

    public static String getFilePath() throws URISyntaxException {
        URL url = JavaTutorApplication.class.getProtectionDomain().getCodeSource().getLocation();
        return Paths.get(url.toURI()).toString();
    }

    public static String getDirectoryPath() throws URISyntaxException {
        String filePath = getFilePath();
        return filePath.substring(0, 1 + filePath.lastIndexOf("/"));
    }

}
