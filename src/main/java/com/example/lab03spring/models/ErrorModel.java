package com.example.lab03spring.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Create a model to handle errors and show messages
 */
@Getter
@Setter
public class ErrorModel {
    private int code;
    private String message;

    public ErrorModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorModel() {

    }
}
