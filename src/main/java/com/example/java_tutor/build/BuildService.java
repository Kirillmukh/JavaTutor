package com.example.java_tutor.build;

import com.example.java_tutor.JavaTutorApplication;
import com.example.java_tutor.file_service.JarFile;
import com.example.java_tutor.file_service.TargetDirectory;

import java.net.URISyntaxException;

public class BuildService {
    private static final boolean BUILD_BY_TARGET = true;

    public static String getPath() throws URISyntaxException {
        if (BUILD_BY_TARGET) {
            return TargetDirectory.getTargetPath(JavaTutorApplication.class);
        }
        return JarFile.getDirectoryPath(JavaTutorApplication.class);

    }
}
