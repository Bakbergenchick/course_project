package com.atymtay.spring.course_project.file;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileUploadResponse {
    private String filename;
    private String downloadURL;
    private long size;
}
