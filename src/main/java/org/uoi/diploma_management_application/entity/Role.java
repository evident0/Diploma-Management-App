package org.uoi.diploma_management_application.entity;

public enum Role {
    STUDENT("Student"),
    PROFESSOR("Professor");

    private final String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}