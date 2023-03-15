package com.example.jwtSecurity.controllers;

import com.example.jwtSecurity.dto.UserDto;
import com.example.jwtSecurity.services.TokenService;
import com.example.jwtSecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("login")
    public ResponseEntity<Void> login(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
