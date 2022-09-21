package com.example.lab03spring.models;

/**
 * Create a model to handle errors and show messages
 */

public class ErrorModel {

    public ErrorModel(String url, Exception exception) {
        this.url = url;
        this.exception = exception;
    }
    private String url;
    private Exception exception;

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
