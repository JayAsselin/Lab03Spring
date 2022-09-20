package com.example.lab03spring.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Create a model to handle errors and show messages
 */

public class ErrorModel {
//    private int code;
//    private String message;
//
//    public ErrorModel(int code, String message) {
//        this.code = code;
//        this.message = message;
//    }
//
//    public ErrorModel() {
//
//    }

    public ErrorModel(String url, Exception exception) {
        this.url = url;
        this.exception = exception;
//        this.message = status.toString();
    }
    private String url;
    private Exception exception;

//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }

    private String message;
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Exception getException() {
        return exception;
    }
    public void setException(Exception exception) {
        this.exception = exception;
    }

}
