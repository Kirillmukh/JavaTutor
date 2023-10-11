package com.example.java_tutor.file_service;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class JarFile {
    public static String getFilePath(Class clazz) throws URISyntaxException {
        URL url = clazz.getProtectionDomain().getCodeSource().getLocation();
        return Paths.get(url.toURI()).toString();
    }

    public static String getDirectoryPath(Class clazz) throws URISyntaxException {
        String filePath = getFilePath(clazz);
        return filePath.substring(0, 1 + filePath.lastIndexOf("/"));
    }

}
