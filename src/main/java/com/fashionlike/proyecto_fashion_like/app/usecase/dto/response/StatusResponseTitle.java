package com.fashionlike.proyecto_fashion_like.app.usecase.dto.response;

public enum StatusResponseTitle {
    CREATED("Created"),
    NOT_CREATED("Not Created"),
    UPDATED("Updated"),
    NOT_UPDATED("Not updating"),
    DELETED("Deleted"),
    NOT_DELETED("Not deleting"),
    FOUND("Found"),
    NOT_FOUND("Not found"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    UNAUTHORIZED("Unauthorized"),
    ;


    private final String message;

    StatusResponseTitle(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}