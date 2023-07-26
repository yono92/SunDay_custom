package com.sunday.sundaycustom.controller;

import com.sunday.sundaycustom.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ValidateController {
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    private ValidateController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/validat-token")
    public ResponseEntity<String> validateToken(@RequestBody String token) {
        boolean isValid = jwtTokenProvider.validateToken(token);
        if (isValid) {
            return ResponseEntity.ok("Token is valid");
        } else {
            return ResponseEntity.status ( HttpStatus.UNAUTHORIZED ).body ( "Token in not vlia" );
        }

    }
}
