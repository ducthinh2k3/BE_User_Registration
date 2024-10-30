package com.example.ia03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ia03.models.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
