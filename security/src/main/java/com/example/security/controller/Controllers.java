package com.example.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {

    @GetMapping("/")
    public String home(HttpServletRequest request){
        return "Welcome to Home page"+request.getSession().getId();
    }
}
