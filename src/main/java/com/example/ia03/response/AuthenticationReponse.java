package com.example.ia03.response;

public class AuthenticationReponse {
    private int status;
    String token;
    private String email;
    
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public AuthenticationReponse() {
    }
    public AuthenticationReponse(int status, String token, String email) {
        this.status = status;
        this.token = token;
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    

    
}
