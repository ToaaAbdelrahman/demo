package com.trial.demo.exception;

public enum DemoError {
    USER_ALREADY_EXISTS(
            "USER_ALREADY_EXISTS",
            "User with this email already exists",
            "E001"),
    USER_NOT_FOUND(
            "USER_NOT_FOUND",
            "User email and/or password is not correct",
            "E002");

    private final String category;
    private final String description;
    private final String code;

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    DemoError(String category, String description, String code) {
        this.category = category;
        this.description = description;
        this.code = code;
    }

    public static DemoError fromString(final String s) {
        if (s != null) {
            for (DemoError error : DemoError.values()) {
                if (s.equals(error.getCategory()) || s.equals(error.getDescription()) || s.equals(error.getCode())) {
                    return error;
                }
            }
        }
        throw new IllegalArgumentException("No valid DemoError for provided string: " + s);
    }
}
