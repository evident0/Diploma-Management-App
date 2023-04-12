package myy803.springboot.sb_tutorial_3_thymeleaf.entity;

public enum Role {
    USER("User"),
    ADMIN("Admin");

    private final String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}