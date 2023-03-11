package com.example.basicAuth.config.security;

public enum UserRole {

    USER("USER"),

    ADMIN("ADMIN");

    private final String name;

    UserRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
