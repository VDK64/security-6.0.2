package com.example.jwtSecurity.entity;

import java.util.List;

import static com.example.jwtSecurity.entity.Permission.COURSE_READ;
import static com.example.jwtSecurity.entity.Permission.COURSE_WRITE;

public enum Role {

    ADMIN(List.of(COURSE_READ, COURSE_WRITE)),
    USER(List.of(COURSE_READ));

    private final List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

}
