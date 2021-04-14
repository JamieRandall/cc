package ru.gov.rkn.model.enums;

import org.springframework.web.util.UriBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum UserRole {
    USER,
    ADMIN;

    public static List<String> getRoles() {
        List<String> roles = new ArrayList<>();
        UserRole[] arrayRoles = UserRole.values();

        for (int i = 0; i < arrayRoles.length; i++) {
            roles.add(arrayRoles[i].toString());
        }

        return roles;
    }
}
