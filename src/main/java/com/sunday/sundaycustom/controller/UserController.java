package com.sunday.sundaycustom.controller;

import com.sunday.sundaycustom.model.User;
import com.sunday.sundaycustom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginPage() {
        return ResponseEntity.ok("Login Page");
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User user) {
        User savedUser = userService.registerUser(user.getUserId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNumber());
        return ResponseEntity.ok(savedUser);
    }
}
