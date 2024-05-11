package com.careerrbear.CareerBear.user.controller;

import com.careerrbear.CareerBear.exceptions.userExceptions.LoginException;
import com.careerrbear.CareerBear.exceptions.userExceptions.SignUpException;
import com.careerrbear.CareerBear.response.Response;
import com.careerrbear.CareerBear.user.model.UserAccount;
import com.careerrbear.CareerBear.user.service.UserService;

import lombok.Builder;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Response<UserAccount>> registerUser(@RequestBody UserAccount user) {
        try {
            UserAccount savedUser = userService.saveUserData(user);
            return ResponseEntity.ok(
                    Response.<UserAccount>builder()
                        .message("New user saved")
                        .detailedMessage("New user has been saved to database")
                        .status(Response.SUCCESS)
                        .responseContent(savedUser)
                        .build()
            );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(
                            Response.<UserAccount>builder()
                                    .message("Error saving new user")
                                    .detailedMessage(ex.getMessage())
                                    .status(Response.FAILURE)
                                    .build()
                    );
        }
    }

    @PostMapping("/delete-user")
    public ResponseEntity<Response<String>> deleteUser(@RequestParam("userId") Long userAccountId) {
        try {
            userService.deleteUserAccount(userAccountId);
            return ResponseEntity.ok(
                    Response.<String>builder()
                            .message("Account has been deleted")
                            .detailedMessage(String.format("Account with id: {%d} has been deleted", userAccountId))
                            .status(Response.SUCCESS)
                            .responseContent("User has been deleted")
                            .build()
            );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(
                            Response.<String>builder()
                                    .message("Error authentication account")
                                    .detailedMessage(ex.getMessage())
                                    .status(Response.FAILURE)
                                    .build()
                    );
        }
    }

    @PostMapping("/delete-all-users")
    public ResponseEntity<Response<String>> deleteAllUsers() {
        try {
            userService.deleteAllUserAccounts();
            return ResponseEntity.ok(
                    Response.<String>builder()
                            .message("Users have been deleted successful")
                            .detailedMessage("All accounts within databases have been erased")
                            .status(Response.SUCCESS)
                            .responseContent("All users have been deleted")
                            .build()
            );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(
                            Response.<String>builder()
                                    .message("Error authentication account")
                                    .detailedMessage(ex.getMessage())
                                    .status(Response.FAILURE)
                                    .build()
                    );
        }
    }

    @GetMapping("/authenticate-user")
    public ResponseEntity<Response<UserAccount>> authenticateUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            UserAccount savedUser = userService.authenticateUser(email, password);
            return ResponseEntity.ok(
                    Response.<UserAccount>builder()
                            .message("authentication successful")
                            .detailedMessage("user has been successfully logged in")
                            .status(Response.SUCCESS)
                            .responseContent(savedUser)
                            .build()
            );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(
                            Response.<UserAccount>builder()
                                    .message("Error authentication account")
                                    .detailedMessage(ex.getMessage())
                                    .status(Response.FAILURE)
                                    .build()
                    );
        }
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<Response<List<UserAccount>>> getAllUserData() {
        try {
            List<UserAccount> savedUser = userService.getAllUserData();
            return ResponseEntity.ok(
                    Response.<List<UserAccount>>builder()
                            .message("authentication successful")
                            .detailedMessage("user has been successfully logged in")
                            .status(Response.SUCCESS)
                            .responseContent(savedUser)
                            .build()
            );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(
                            Response.<List<UserAccount>>builder()
                                    .message("Error authentication account")
                                    .detailedMessage(ex.getMessage())
                                    .status(Response.FAILURE)
                                    .build()
                    );
        }
    }
}