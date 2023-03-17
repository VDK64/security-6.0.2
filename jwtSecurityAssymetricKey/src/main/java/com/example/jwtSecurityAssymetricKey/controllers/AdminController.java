package com.example.jwtSecurityAssymetricKey.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public ResponseEntity<String> hello(Authentication authentication) {
        return ResponseEntity.ok(String.format("Hello %s", authentication.getName()));
    }

}
