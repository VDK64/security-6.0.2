package com.example.jwtSecurity.entity;

public enum Permission {

    COURSE_READ("SCOPE_course:read"),
    COURSE_WRITE("SCOPE_course:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

}
