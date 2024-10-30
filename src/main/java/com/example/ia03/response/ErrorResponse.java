package com.example.ia03.response;

import java.util.List;

public class ErrorResponse {
    private int status;
    private String error;
    private List<String> details;

    public ErrorResponse(int status, String error, List<String> details) {
        this.error = error;
        this.status = status;
        this.details = details;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public List<String> getDetails() {
        return details;
    }
    public void setDetails(List<String> details) {
        this.details = details;
    }

    
}
