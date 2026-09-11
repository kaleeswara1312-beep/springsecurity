package com.example.demo.util;

import java.util.Set;

public enum Role {

    ADMIN(
            Permission.USER_READ,
            Permission.USER_CREATE,
            Permission.USER_UPDATE,
            Permission.USER_DELETE
    ),

    MANAGER(
            Permission.USER_READ,
            Permission.USER_UPDATE
    ),

    USER(
            Permission.USER_READ
    );

    private final Set<Permission> permissions;

    Role(Permission... permissions) {
        this.permissions = Set.of(permissions);
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}