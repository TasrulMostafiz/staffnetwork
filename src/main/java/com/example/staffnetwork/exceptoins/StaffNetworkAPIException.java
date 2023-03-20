package com.example.staffnetwork.exceptoins;

import org.springframework.http.HttpStatus;

public class StaffNetworkAPIException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public StaffNetworkAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public StaffNetworkAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
