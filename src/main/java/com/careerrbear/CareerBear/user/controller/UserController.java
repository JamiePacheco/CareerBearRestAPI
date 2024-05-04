package com.careerrbear.CareerBear.user.controller;

import com.careerrbear.CareerBear.user.model.User;
import com.careerrbear.CareerBear.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> UserCallTest() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping("/save-user")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUserData(user));
    }

}