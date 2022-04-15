package com.atymtay.spring.course_project.controller;


import com.atymtay.spring.course_project.file.FileDownloadUtil;
import com.atymtay.spring.course_project.file.FileUploadResponse;
import com.atymtay.spring.course_project.file.FileUploadUtil;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/file")
public class FileUploadController {

    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile multipartFile
            ) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();

        String fileCode = FileUploadUtil.saveFile(fileName, multipartFile);

        FileUploadResponse fileUploadResponse = new FileUploadResponse();
        fileUploadResponse.setFilename(fileName);
        fileUploadResponse.setSize(size);
        fileUploadResponse.setDownloadURL("/downloadFile/" + fileCode);

        return new ResponseEntity<>(fileUploadResponse, HttpStatus.OK);
    }

    @GetMapping("/downloadFile/{fileCode}")
    public ResponseEntity<?> downloadFile(
            @PathVariable("fileCode") String fileCode){
        FileDownloadUtil fileDownloadUtil = new FileDownloadUtil();

        Resource resource = null;

        try{
            resource = fileDownloadUtil.getFileAsResource(fileCode);
        }catch (IOException e){
            return ResponseEntity.internalServerError().build();
        }

        if(resource == null){
            return new ResponseEntity<>("File not found",HttpStatus.NOT_FOUND);
        }

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";


        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }
}
