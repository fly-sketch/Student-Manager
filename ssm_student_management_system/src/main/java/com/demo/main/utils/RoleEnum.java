package com.demo.main.utils;

import lombok.Getter;

@Getter
public enum RoleEnum {
    STUDENT("student"),
    TEACHER("teacher"),
    ADMIN("admin");

    private final String role;

    RoleEnum(String role) {
        this.role = role;
    }
}
