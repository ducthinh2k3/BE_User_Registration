package com.example.ia03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping("/home")
    public String getHomePage(){
        return "Home";
    }
}
