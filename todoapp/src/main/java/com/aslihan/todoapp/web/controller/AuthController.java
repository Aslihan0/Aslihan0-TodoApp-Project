package com.aslihan.todoapp.web.controller;

import com.aslihan.todoapp.service.UserService;
import com.aslihan.todoapp.web.request.CreateUserRequest;
import com.aslihan.todoapp.web.request.LoginUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.message.AuthException;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signup(@RequestBody CreateUserRequest createUserRequest) {
        try {
            userService.createUser(createUserRequest);
            return ResponseEntity.ok("success");
        } catch (AuthException e) {
            return ResponseEntity.status(405).body("user already register");
        }

    }
    @PostMapping("/sign-in")
    public ResponseEntity<?> login(@RequestBody LoginUserRequest loginUserRequest) {
        if (userService.getUserByUsernameAndPassword(loginUserRequest.getUsername(), loginUserRequest.getPassword()) == null){
            return ResponseEntity.status(401).body("login failed");

        }
        return ResponseEntity.ok("login successfully");
    }

}
