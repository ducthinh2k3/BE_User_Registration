package com.example.ia03.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.example.ia03.exceptions.LoginFailException;
import com.example.ia03.exceptions.ValidationException;
import com.example.ia03.models.User;
import com.example.ia03.request.LoginRequest;
import com.example.ia03.response.SuccessResponse;
import com.example.ia03.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    private final PasswordEncoder passwordEncoder;

    public UserController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/get-users")
    public ResponseEntity<List<User>> getAllProducts(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest user) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );
            SuccessResponse response = new SuccessResponse(HttpStatus.ACCEPTED.value(), "Login successfully", user.getEmail());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } catch (Exception e) {
            throw new LoginFailException("Username or password is incorrect");
        }

    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser (@RequestBody @Valid User user, BindingResult bindingResult){
            // check username and password is valid (not blank)
            if (bindingResult.hasErrors()) {
                List<String> errors = bindingResult.getAllErrors()
                                                   .stream()
                                                   .map(ObjectError::getDefaultMessage)
                                                   .collect(Collectors.toList());
                throw new ValidationException(errors);
            }

            if(userService.findByEmail(user.getEmail()) != null){
                throw new RuntimeException("User already exists");
            }
            
            User newUser = new User();
            newUser.setEmail(user.getEmail());
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.saveUser(newUser);
            
            SuccessResponse response = new SuccessResponse(HttpStatus.CREATED.value(), "User created successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
            
    }
}
