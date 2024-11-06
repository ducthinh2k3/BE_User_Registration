package com.example.ia03.response;

import java.time.LocalDateTime;

public class UserCreateResponse {
    private String userId;
    private String email;
    private LocalDateTime createdAt;

    public UserCreateResponse(String userId, String email, LocalDateTime createdAt) {
        this.userId = userId;
        this.email = email;
        this.createdAt = createdAt;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    


}
