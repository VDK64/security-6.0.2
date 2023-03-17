package com.example.jwtSecurityAssymetricKey.controllers;

import com.example.jwtSecurityAssymetricKey.services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final TokenService tokenService;

    @GetMapping
    public ResponseEntity<String> login(Authentication authentication) {
        return ResponseEntity.ok(tokenService.generateToken(authentication));
    }

}
