package com.example.basicAuth.dto;

import com.example.basicAuth.config.security.UserRole;

import java.util.Set;

public record UserDto(String firstname, String lastname,
                      String password, String username,
                      Set<UserRole> roles) {
}
