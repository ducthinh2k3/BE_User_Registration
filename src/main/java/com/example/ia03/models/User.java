package com.example.ia03.models;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User {

    @Id
    private String userId;

    @Indexed(unique = true)
    @NotBlank(message = "Email is not null")
    private String email;

    @Size(min = 5, message="Password must be at least 5 characters")
    @NotBlank(message = "Password is not null")
    private String password;

    private LocalDateTime createdAt = LocalDateTime.now();

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    
}
