package disi.controllers;



import org.springframework.http.HttpStatus;

import java.util.ArrayList;

public class ExceptionWish extends CustomWish {
    private static final String MESSAGE = "Resource not found!";
    private static final int  httpStatus =404;
    private static final int status=0;

    public ExceptionWish(String resource, int status) {
        super(MESSAGE, status, resource, new ArrayList<>());
    }
}