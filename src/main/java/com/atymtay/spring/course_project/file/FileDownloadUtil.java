package com.atymtay.spring.course_project.file;


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownloadUtil {

    private Path foundFile;

    public Resource getFileAsResource(String fileCode) throws IOException {
        Path uploadDriectory = Paths.get("Files-Upload");

        Files.list(uploadDriectory).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileCode)){
                foundFile = file;
                return;
            }
        });

        if(foundFile != null){
            return new UrlResource(foundFile.toUri());
        }

        return null;
    }
}
