package com.careerrbear.CareerBear.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping("/test")
    public ResponseEntity<String> UserCallTest() {
        return ResponseEntity.ok("Hello World");
    }
}