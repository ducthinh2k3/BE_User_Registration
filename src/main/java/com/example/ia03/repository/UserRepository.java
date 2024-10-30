package com.example.ia03.repository;

import com.example.ia03.models.User;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
