package com.careerrbear.CareerBear.user.controller;

import com.careerrbear.CareerBear.user.model.UserAccount;
import com.careerrbear.CareerBear.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<UserAccount> registerUser(@RequestBody UserAccount user) {
        return ResponseEntity.ok(userService.saveUserData(user));
    }

    @PostMapping("/delete-user")
    public ResponseEntity<String> deleteUser(@RequestParam("userId") Long userAccountId) {
        userService.deleteUserAccount(userAccountId);
        return ResponseEntity.ok("Account Has Been Deleted");
    }

    @PostMapping("/delete-all-users")
    public ResponseEntity<String> deleteAllUsers() {
        userService.deleteAllUserAccounts();
        return ResponseEntity.ok("All users have been deleted");
    }

    @GetMapping("/authenticate-user")
    public ResponseEntity<UserAccount> authenticateUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        return ResponseEntity.ok(userService.authenticateUser(email, password));
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<List<UserAccount>> getAllUserData() {
        return ResponseEntity.ok(userService.getAllUserData());
    }
}