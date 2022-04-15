package com.atymtay.spring.course_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(CustomErrorException.class)
    public ResponseEntity<ErrorResponse> globalExceptionHandler(
            Exception e
    ) {
        CustomErrorException customErrorException = ((CustomErrorException) e);

        HttpStatus httpStatus = customErrorException.getStatus();
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        customErrorException.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();


        return new ResponseEntity<>(
                new ErrorResponse(
                        httpStatus,
                        customErrorException.getMessage(),
                        stackTrace,
                        customErrorException.getData()

                ),
                httpStatus
        );
    }


    @ExceptionHandler
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> badRequestExceptionHandler(
            Exception e
    ) {


        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();


        return new ResponseEntity<>(
                new ErrorResponse(
                        HttpStatus.BAD_REQUEST,
                        e.getMessage(),
                        stackTrace
                ),
                HttpStatus.BAD_REQUEST
        );
    }
}
