package com.example.basicAuth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Secured({"ROLE_USER"})
public class UserController {

    @GetMapping("/hello")
    public ResponseEntity<String> userHello() {
        return ResponseEntity.ok("Hello only for users");
    }

}
