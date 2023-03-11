package com.example.basicAuth.config.security;

public enum UserPermission {

    COURSE_READ("course:read"),

    COURSE_WRITE("course:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

}
