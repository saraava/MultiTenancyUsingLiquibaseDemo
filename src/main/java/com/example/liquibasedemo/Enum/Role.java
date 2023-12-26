package com.example.liquibasedemo.Enum;

public enum Role {
    SUPER_ADMIN("super_admin"),
    ADMIN("admin"),
    USER("user");

    private String role;

    Role(String role) {
        this.role = role;
    }
}
