package com.example.basicAuth.config.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.basicAuth.config.security.UserPermission.COURSE_READ;
import static com.example.basicAuth.config.security.UserPermission.COURSE_WRITE;

public enum UserRole {

    USER(new HashSet<>(List.of(COURSE_READ))),

    ADMIN(new HashSet<>(List.of(COURSE_READ, COURSE_WRITE)));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

}
