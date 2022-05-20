package disi.controllers;

import org.springframework.http.HttpStatus;

import java.util.List;

public class CustomWish extends RuntimeException {
    private final String resource;
    private final int status;
    private final List<String> validationErrors;

    public CustomWish (String message, int status, String resource, List<String> errors) {
        super(message);
        this.resource = resource;
        this.validationErrors = errors;
        this.status = status;
    }

    public String getResource() {
        return resource;
    }

    public int getStatus() {
        return status;
    }

    public List<String> getValidationErrors() {
        return validationErrors;
    }
}
