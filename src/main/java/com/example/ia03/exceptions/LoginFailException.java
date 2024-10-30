package com.example.ia03.exceptions;

public class LoginFailException extends RuntimeException {
    private String error;

    public LoginFailException(String error) {
        super(error);
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
